package srOntoInd4;

import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formattable;
import java.util.Formatter;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.XMLFormatter;
import org.apache.jena.atlas.json.io.parser.JSONParser;
import org.apache.jena.riot.RDFFormat;
import org.apache.log4j.PropertyConfigurator;
import org.apache.xerces.parsers.XML11Configurable;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.markers.SeriesMarkers;
import org.mindswap.pellet.jena.PelletReasoner;
import org.mindswap.pellet.jena.PelletReasonerFactory;
import org.semanticweb.HermiT.Configuration;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.HermiT.Reasoner.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLIndividualAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.ConsoleProgressMonitor;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.semanticweb.owlapi.util.InferredAxiomGenerator;
import org.semanticweb.owlapi.util.InferredClassAssertionAxiomGenerator;
import org.semanticweb.owlapi.util.InferredIndividualAxiomGenerator;
import org.semanticweb.owlapi.util.InferredInverseObjectPropertiesAxiomGenerator;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;
import org.semanticweb.owlapi.util.InferredSubDataPropertyAxiomGenerator;
import org.semanticweb.owlapi.util.InferredSubObjectPropertyAxiomGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.swrlapi.core.SWRLRuleEngine;
import org.swrlapi.factory.SWRLAPIFactory;
import org.swrlapi.sqwrl.SQWRLQueryEngine;
import org.swrlapi.sqwrl.SQWRLResult;
import com.hp.hpl.jena.sparql.engine.binding.Binding;
import com.hp.hpl.jena.vocabulary.RDF;
import eu.larkc.csparql.cep.api.RdfStream;
import eu.larkc.csparql.common.RDFTable;
import eu.larkc.csparql.common.utils.CsparqlUtils;
import eu.larkc.csparql.common.utils.ReasonerChainingType;
import eu.larkc.csparql.core.engine.CsparqlEngineImpl;
import eu.larkc.csparql.core.engine.CsparqlQueryResultProxy;
import eu.larkc.csparql.core.engine.RDFStreamFormatter;
import srOntoInd4.ConsoleFormatter;
import srOntoInd4.streamer.SensorsStreamer;

public class Example {

	private static Logger logger = LoggerFactory.getLogger(Example.class);

	public static void main(String[] args) {

		try{
			
			//Configure log4j logger for the csparql engine
			PropertyConfigurator.configure("log4j_configuration/csparql_readyToGoPack_log4j.properties");

			//Create csparql engine
			CsparqlEngineImpl engine = new CsparqlEngineImpl();
			//Initialize the engine instance
			engine.initialize(true);

			//Put static model
			engine.putStaticNamedModel("http://streamreasoning.org/ContextOntology-COInd4",CsparqlUtils.serializeRDFFile("/home/franco/Repositories/SR-OntoInd4/SROntoInd4/ContextOntology-COInd4.owl"));
			
			String fileOntology = "/home/franco/Repositories/SR-OntoInd4/SROntoInd4/ContextOntology-COInd4.owl";//ContextOntology-COInd4.owl";
			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			OWLDataFactory factory = manager.getOWLDataFactory();
			String ontologyURI = "http://semanticweb.org/STEaMINg/ContextOntology-COInd4";
			String ns = ontologyURI + "#";
			final OWLOntology ontology = manager.loadOntologyFromOntologyDocument(new File(fileOntology));
			
			//Create SWRL engines
			//SWRLRuleEngine ruleEngine = SWRLAPIFactory.createSWRLRuleEngine(ontology);
			//ruleEngine.infer();
			OWLReasonerFactory reasonerFactory = new ReasonerFactory();
			OWLReasoner ruleEngine = reasonerFactory.createReasoner(ontology);


			String queryS1 = "REGISTER QUERY S1detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 ?o4 "
				+ "FROM STREAM <Stream_S_G_current> [RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_C_temp> 		[RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_T_temp> 		[RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_OilTemp> 	[RANGE 20s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m           :isPartOf        ?pl ."
				+ " ?m           sosa:hosts       sosa:S_G_current ." 
				+ " :S_G_current :madeObservation ?o1 ."
				+ " ?o1          :hasSimpleResult ?v1 ."
				+ " ?m           sosa:hosts       sosa:S_C_temp ."
				+ " :S_C_temp    :madeObservation ?o2 ."
				+ " ?o2          :hasSimpleResult ?v2 ."
				+ " ?m           sosa:hosts       sosa:S_T_temp ."
				+ " :S_T_temp    :madeObservation ?o3 ."
				+ " ?o3          :hasSimpleResult ?v3 ."
				+ " ?m           sosa:hosts       sosa:S_OilTemp ."
				+ " :S_OilTemp   :madeObservation ?o4 ."
				+ " ?o4          :hasSimpleResult ?v3 ."
				+ " FILTER ( "
				+ "		?v1 > 800.0 && "
				+ "		?v2 > 40.0  && "
				+ "		?v3 > 45.0  && "
				+ "		?v4 > 40.0 ) . "
				+ "} ";

			String queryS2 = "REGISTER QUERY S2detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 ?o4 "
				+ "FROM STREAM <Stream_S_G_current> [RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_C_temp> 		[RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_T_temp> 		[RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_OilTemp> 	[RANGE 20s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m           :isPartOf        ?pl ."
				+ " ?m           sosa:hosts       sosa:S_G_current ." 
				+ " :S_G_current :madeObservation ?o1 ."
				+ " ?o1          :hasSimpleResult ?v1 ."
				+ " ?m           sosa:hosts       sosa:S_C_temp ."
				+ " :S_C_temp    :madeObservation ?o2 ."
				+ " ?o2          :hasSimpleResult ?v2 ."
				+ " ?m           sosa:hosts       sosa:S_T_temp ."
				+ " :S_T_temp    :madeObservation ?o3 ."
				+ " ?o3          :hasSimpleResult ?v3 ."
				+ " ?m           sosa:hosts       sosa:S_OilTemp ."
				+ " :S_OilTemp   :madeObservation ?o4 ."
				+ " ?o4          :hasSimpleResult ?v3 ."
				+ " FILTER ( "
				+ "		?v1 > 800.0 && "
				+ "		?v2 > 40.0  && "
				+ "		?v3 > 45.0  && "
				+ "		?v4 > 60.0 ) . "
				+ "} ";

			String queryS3 = "REGISTER QUERY S3detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 ?o4 "
				+ "FROM STREAM <Stream_S_P_temp> 	[RANGE 25s STEP 5s] "
				+ "FROM STREAM <Stream_S_GB_temp> [RANGE 25s STEP 5s] "
				+ "FROM STREAM <Stream_S_G_speed> [RANGE 25s STEP 5s] "
				+ "FROM STREAM <Stream_S_E_temp> 	[RANGE 25s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m           :isPartOf        ?pl ."
				+ " ?m           sosa:hosts       sosa:S_P_temp ." 
				+ " :S_P_temp    :madeObservation ?o1 ."
				+ " ?o1          :hasSimpleResult ?v1 ."
				+ " ?m           sosa:hosts       sosa:S_GB_temp ." 
				+ " :S_GB_temp   :madeObservation ?o2 ."
				+ " ?o2          :hasSimpleResult ?v2 ."
				+ " ?m           sosa:hosts       sosa:S_G_speed ." 
				+ " :S_G_speed   :madeObservation ?o3 ."
				+ " ?o3          :hasSimpleResult ?v3 ."
				+ " ?m           sosa:hosts       sosa:S_E_temp ." 
				+ " :S_E_temp    :madeObservation ?o4 ."
				+ " ?o4          :hasSimpleResult ?v4 ."
				+ " FILTER ( "
				+ "		?v1 < 35.0   && "
				+ "		?v2 > 40.0   && "
				+ "		?v3 < 500.0  && "
				+ "		?v4 < 25.0 ) . "
				+ "} ";

			String queryS4 = "REGISTER QUERY S4detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 ?o4 "
				+ "FROM STREAM <Stream_S_P_temp> 	[RANGE 25s STEP 5s] "
				+ "FROM STREAM <Stream_S_GB_temp> [RANGE 25s STEP 5s] "
				+ "FROM STREAM <Stream_S_G_speed> [RANGE 25s STEP 5s] "
				+ "FROM STREAM <Stream_S_E_temp> 	[RANGE 25s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m           :isPartOf        ?pl ."
				+ " ?m           sosa:hosts       sosa:S_P_temp ." 
				+ " :S_P_temp    :madeObservation ?o1 ."
				+ " ?o1          :hasSimpleResult ?v1 ."
				+ " ?m           sosa:hosts       sosa:S_GB_temp ." 
				+ " :S_GB_temp   :madeObservation ?o2 ."
				+ " ?o2          :hasSimpleResult ?v2 ."
				+ " ?m           sosa:hosts       sosa:S_G_speed ." 
				+ " :S_G_speed   :madeObservation ?o3 ."
				+ " ?o3          :hasSimpleResult ?v3 ."
				+ " ?m           sosa:hosts       sosa:S_E_temp ." 
				+ " :S_E_temp    :madeObservation ?o4 ."
				+ " ?o4          :hasSimpleResult ?v4 ."
				+ " FILTER ( "
				+ "		?v1 < 35.0   && "
				+ "		?v2 > 60.0   && "
				+ "		?v3 < 500.0  && "
				+ "		?v4 < 25.0 ) . "
				+ "} ";

			String queryS5 = "REGISTER QUERY S5detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 ?o4 "
				+ "FROM STREAM <Stream_S_P_temp> 	[RANGE 25s STEP 5s] "
				+ "FROM STREAM <Stream_S_GB_temp> [RANGE 25s STEP 5s] "
				+ "FROM STREAM <Stream_S_G_speed> [RANGE 25s STEP 5s] "
				+ "FROM STREAM <Stream_S_E_temp> 	[RANGE 25s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m           :isPartOf        ?pl ."
				+ " ?m           sosa:hosts       sosa:S_P_temp ." 
				+ " :S_P_temp    :madeObservation ?o1 ."
				+ " ?o1          :hasSimpleResult ?v1 ."
				+ " ?m           sosa:hosts       sosa:S_GB_temp ." 
				+ " :S_GB_temp   :madeObservation ?o2 ."
				+ " ?o2          :hasSimpleResult ?v2 ."
				+ " ?m           sosa:hosts       sosa:S_G_speed ." 
				+ " :S_G_speed   :madeObservation ?o3 ."
				+ " ?o3          :hasSimpleResult ?v3 ."
				+ " ?m           sosa:hosts       sosa:S_E_temp ." 
				+ " :S_E_temp    :madeObservation ?o4 ."
				+ " ?o4          :hasSimpleResult ?v4 ."
				+ " FILTER ( "
				+ "		?v1 > 40.0   && "
				+ "		?v2 > 60.0   && "
				+ "		?v3 < 500.0  && "
				+ "		?v4 < 25.0 ) . "
				+ "} ";

			String queryS6 = "REGISTER QUERY S6detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 "
				+ "FROM STREAM <Stream_S_C_Wtemp> [RANGE 15s STEP 5s] "
				+ "FROM STREAM <Stream_S_TG_temp> [RANGE 15s STEP 5s] "
				+ "FROM STREAM <Stream_S_G_temp> 	[RANGE 15s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m         :isPartOf        ?pl ."
				+ " ?m         sosa:hosts       sosa:S_C_Wtemp ." 
				+ " :S_C_Wtemp :madeObservation ?o1 ."
				+ " ?o1        :hasSimpleResult ?v1 ."
				+ " ?m         sosa:hosts       sosa:S_TG_temp ."
				+ " :S_TG_temp :madeObservation ?o2 ."
				+ " ?o2        :hasSimpleResult ?v2 ."
				+ " ?m         sosa:hosts       sosa:S_G_temp ."
				+ " :S_G_temp  :madeObservation ?o3 ."
				+ " ?o3        :hasSimpleResult ?v3 ."
				+ " FILTER ( "
				//+ "		?v1 > 1.0 && "
				//+ "		?v2 > 1.0 && "
				//+ "		?v3 > 1.0 ) . "
				+ "		?v1 > 60.0 && "
				+ "		?v2 < 35.0 && "
				+ "		?v3 > 45.0 ) . "
				+ "} ";

			String queryS7 = "REGISTER QUERY S7detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 "
				+ "FROM STREAM <Stream_S_C_Wtemp> [RANGE 15s STEP 5s] "
				+ "FROM STREAM <Stream_S_TG_temp> [RANGE 15s STEP 5s] "
				+ "FROM STREAM <Stream_S_G_temp> 	[RANGE 15s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m         :isPartOf        ?pl ."
				+ " ?m         sosa:hosts       sosa:S_C_Wtemp ." 
				+ " :S_C_Wtemp :madeObservation ?o1 ."
				+ " ?o1        :hasSimpleResult ?v1 ."
				+ " ?m         sosa:hosts       sosa:S_TG_temp ."
				+ " :S_TG_temp :madeObservation ?o2 ."
				+ " ?o2        :hasSimpleResult ?v2 ."
				+ " ?m         sosa:hosts       sosa:S_G_temp ."
				+ " :S_G_temp  :madeObservation ?o3 ."
				+ " ?o3        :hasSimpleResult ?v3 ."
				+ " FILTER ( "
				+ "		?v1 > 80.0 && "
				+ "		?v2 < 35.0 && "
				+ "		?v3 > 45.0 ) . "
				+ "} ";

			String queryS8 = "REGISTER QUERY S8detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 "
				+ "FROM STREAM <Stream_S_P_temp> 		[RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_TG_temp> 	[RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_Conv_temp> [RANGE 20s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m            :isPartOf        ?pl ."
				+ " ?m            sosa:hosts       sosa:S_P_temp ." 
				+ " :S_P_temp     :madeObservation ?o1 ."
				+ " ?o1           :hasSimpleResult ?v1 ."
				+ " ?m            sosa:hosts       sosa:S_TG_temp ."
				+ " :S_TG_temp    :madeObservation ?o2 ."
				+ " ?o2           :hasSimpleResult ?v2 ."
				+ " ?m            sosa:hosts       sosa:S_Conv_temp ."
				+ " :S_Conv_temp  :madeObservation ?o3 ."
				+ " ?o3           :hasSimpleResult ?v3 ."
				+ " FILTER ( "
				+ "		?v1 < 35.0 && "
				+ "		?v2 < 35.0 && "
				+ "		?v3 > 60.0 ) . "
				+ "} ";

			String queryS9 = "REGISTER QUERY S9detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 "
				+ "FROM STREAM <Stream_S_P_temp> 		[RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_TG_temp> 	[RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_Conv_temp> [RANGE 20s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m            :isPartOf        ?pl ."
				+ " ?m            sosa:hosts       sosa:S_P_temp ." 
				+ " :S_P_temp     :madeObservation ?o1 ."
				+ " ?o1           :hasSimpleResult ?v1 ."
				+ " ?m            sosa:hosts       sosa:S_TG_temp ."
				+ " :S_TG_temp    :madeObservation ?o2 ."
				+ " ?o2           :hasSimpleResult ?v2 ."
				+ " ?m            sosa:hosts       sosa:S_Conv_temp ."
				+ " :S_Conv_temp  :madeObservation ?o3 ."
				+ " ?o3           :hasSimpleResult ?v3 ."
				+ " FILTER ( "
				+ "		?v1 < 35.0 && "
				+ "		?v2 < 35.0 && "
				+ "		?v3 > 80.0 ) . "
				+ "} ";

			String queryS10 = "REGISTER QUERY S10detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 ?o4 "
				+ "FROM STREAM <Stream_S_C_Wtemp> 	[RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_TG_temp> 	[RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_Conv_temp> [RANGE 20s STEP 5s] "
				+ "FROM STREAM <Stream_S_G_temp> 		[RANGE 20s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m            :isPartOf        ?pl ."
				+ " ?m            sosa:hosts       sosa:S_C_Wtemp ." 
				+ " :S_C_Wtemp    :madeObservation ?o1 ."
				+ " ?o1           :hasSimpleResult ?v1 ."
				+ " ?m            sosa:hosts       sosa:S_TG_temp ."
				+ " :S_TG_temp    :madeObservation ?o2 ."
				+ " ?o2           :hasSimpleResult ?v2 ."
				+ " ?m            sosa:hosts       sosa:S_Conv_temp ."
				+ " :S_Conv_temp  :madeObservation ?o3 ."
				+ " ?o3           :hasSimpleResult ?v3 ."
				+ " ?m            sosa:hosts       sosa:S_G_temp ."
				+ " :S_G_temp     :madeObservation ?o4 ."
				+ " ?o4           :hasSimpleResult ?v4 ."
				+ " FILTER ( "
				+ "		?v1 > 80.0 && "
				+ "		?v2 < 35.0 && "
				+ "		?v3 > 60.0 && "
				+ "		?v4 < 45.0 ) . "
				+ "} ";

			String queryS11 = "REGISTER QUERY S11detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 "
				+ "FROM STREAM <Stream_S_PowerOutput> [RANGE 30s STEP 5s] "
				+ "FROM STREAM <Stream_S_R_speed> 		[RANGE 30s STEP 5s] "
				+ "FROM STREAM <Stream_S_R_Pangle> 		[RANGE 30s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m             :isPartOf        ?pl ."
				+ " ?m             sosa:hosts       sosa:S_PowerOutput ." 
				+ " :S_PowerOutput :madeObservation ?o1 ."
				+ " ?o1            :hasSimpleResult ?v1 ."
				+ " ?m             sosa:hosts       sosa:S_R_speed ."
				+ " :S_R_speed     :madeObservation ?o2 ."
				+ " ?o2            :hasSimpleResult ?v2 ."
				+ " ?m             sosa:hosts       sosa:S_R_Pangle ."
				+ " :S_R_Pangle    :madeObservation ?o3 ."
				+ " ?o3            :hasSimpleResult ?v3 ."
				+ " FILTER ( "
				+ "		?v1 > 2000.0 && "
				+ "		?v2 < 200.0 && "
				+ "		?v3 < 5.0 ) . "
				+ "} ";

			String queryS12 = "REGISTER QUERY S12detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 "
				+ "FROM STREAM <Stream_S_PowerOutput> [RANGE 30s STEP 5s] "
				+ "FROM STREAM <Stream_S_R_speed> 		[RANGE 30s STEP 5s] "
				+ "FROM STREAM <Stream_S_R_Pangle> 		[RANGE 30s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m             :isPartOf        ?pl ."
				+ " ?m             sosa:hosts       sosa:S_PowerOutput ." 
				+ " :S_PowerOutput :madeObservation ?o1 ."
				+ " ?o1            :hasSimpleResult ?v1 ."
				+ " ?m             sosa:hosts       sosa:S_R_speed ."
				+ " :S_R_speed     :madeObservation ?o2 ."
				+ " ?o2            :hasSimpleResult ?v2 ."
				+ " ?m             sosa:hosts       sosa:S_R_Pangle ."
				+ " :S_R_Pangle    :madeObservation ?o3 ."
				+ " ?o3            :hasSimpleResult ?v3 ."
				+ " FILTER ( "
				+ "		?v1 > 2000.0 && "
				+ "		?v2 < 100.0 && "
				+ "		?v3 < 5.0 ) . "
				+ "} ";

			String queryS13 = "REGISTER QUERY S13detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 "
				+ "FROM STREAM <Stream_S_PowerOutput> [RANGE 35s STEP 5s] "
				+ "FROM STREAM <Stream_S_R_speed> 		[RANGE 35s STEP 5s] "
				+ "FROM STREAM <Stream_S_R_Pangle> 		[RANGE 35s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m             :isPartOf        ?pl ."
				+ " ?m             sosa:hosts       sosa:S_PowerOutput ." 
				+ " :S_PowerOutput :madeObservation ?o1 ."
				+ " ?o1            :hasSimpleResult ?v1 ."
				+ " ?m             sosa:hosts       sosa:S_R_speed ."
				+ " :S_R_speed     :madeObservation ?o2 ."
				+ " ?o2            :hasSimpleResult ?v2 ."
				+ " ?m             sosa:hosts       sosa:S_R_Pangle ."
				+ " :S_R_Pangle    :madeObservation ?o3 ."
				+ " ?o3            :hasSimpleResult ?v3 ."
				+ " FILTER ( "
				+ "		?v1 < 500.0 && "
				+ "		?v2 < 200.0 && "
				+ "		?v3 < 5.0 ) . "
				+ "} ";

			String queryS14 = "REGISTER QUERY S14detection AS "
				+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
				+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
				+ "SELECT ?m ?pl ?o1 ?o2 ?o3 "
				+ "FROM STREAM <Stream_S_PowerOutput> [RANGE 35s STEP 5s] "
				+ "FROM STREAM <Stream_S_R_speed> 		[RANGE 35s STEP 5s] "
				+ "FROM STREAM <Stream_S_R_Pangle> 		[RANGE 35s STEP 5s] "
				+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
				+ "WHERE { "
				+ " ?m             :isPartOf        ?pl ."
				+ " ?m             sosa:hosts       sosa:S_PowerOutput ." 
				+ " :S_PowerOutput :madeObservation ?o1 ."
				+ " ?o1            :hasSimpleResult ?v1 ."
				+ " ?m             sosa:hosts       sosa:S_R_speed ."
				+ " :S_R_speed     :madeObservation ?o2 ."
				+ " ?o2            :hasSimpleResult ?v2 ."
				+ " ?m             sosa:hosts       sosa:S_R_Pangle ."
				+ " :S_R_Pangle    :madeObservation ?o3 ."
				+ " ?o3            :hasSimpleResult ?v3 ."
				+ " FILTER ( "
				+ "		?v1 < 200.0 && "
				+ "		?v2 < 200.0 && "
				+ "		?v3 < 5.0 ) . "
				+ "} ";

			
			double[] data_C_Wtemp = new double[100];
			double[] data_TG_temp = new double[100];
			double[] data_G_temp = new double[100];
			double[] data_P_temp = new double[100];
			double[] data_E_temp = new double[100];
			double[] data_PowerOutput = new double[100];
			double[] data_G_current = new double[100];
			double[] data_C_temp = new double[100];
			double[] data_T_temp = new double[100];
			double[] data_OilTemp = new double[100];
			double[] data_GB_temp = new double[100];
			double[] data_G_speed = new double[100];
			double[] data_Conv_temp = new double[100];
			double[] data_R_speed = new double[100];
			double[] data_R_Pangle = new double[100];

			double phase = 0;
			
			double[][] initdata_C_Wtemp = getArrX(phase,data_C_Wtemp);
			double[][] initdata_TG_temp = getArrX(phase,data_TG_temp);
			double[][] initdata_G_temp = getArrX(phase,data_G_temp);
			double[][] initdata_P_temp = getArrX(phase,data_P_temp);
			double[][] initdata_E_temp = getArrX(phase,data_E_temp);
			double[][] initdata_PowerOutput = getArrX(phase,data_PowerOutput);
			double[][] initdata_G_current = getArrX(phase,data_G_current);
			double[][] initdata_C_temp = getArrX(phase,data_C_temp);
			double[][] initdata_T_temp = getArrX(phase,data_T_temp);
			double[][] initdata_OilTemp = getArrX(phase,data_OilTemp);
			double[][] initdata_GB_temp = getArrX(phase,data_GB_temp);
			double[][] initdata_G_speed = getArrX(phase,data_G_speed);
			double[][] initdata_Conv_temp = getArrX(phase,data_Conv_temp);
			double[][] initdata_R_speed = getArrX(phase,data_R_speed);
			double[][] initdata_R_Pangle = getArrX(phase,data_R_Pangle);

			final XYChart chart = QuickChart.getChart("Real-time System parameters PL1", "Time", "Values", "C_Wtemp", initdata_C_Wtemp[0], initdata_C_Wtemp[1]);
			chart.getStyler().setLegendPosition(LegendPosition.OutsideE);
			XYSeries series_TG_temp = chart.addSeries("TG_temp", initdata_TG_temp[0],initdata_TG_temp[1]);
			series_TG_temp.setMarker(SeriesMarkers.NONE);
			XYSeries series_G_temp = chart.addSeries("G_temp", initdata_G_temp[0],initdata_G_temp[1]);
			series_G_temp.setMarker(SeriesMarkers.NONE);
			XYSeries series_P_temp = chart.addSeries("P_temp", initdata_P_temp[0],initdata_P_temp[1]);
			series_P_temp.setMarker(SeriesMarkers.NONE);
			XYSeries series_E_temp = chart.addSeries("E_temp", initdata_E_temp[0],initdata_E_temp[1]);
			series_E_temp.setMarker(SeriesMarkers.NONE);
			XYSeries series_PowerOutput = chart.addSeries("PowerOutput", initdata_PowerOutput[0],initdata_PowerOutput[1]);
			series_PowerOutput.setMarker(SeriesMarkers.NONE);
			XYSeries series_G_current = chart.addSeries("G_current", initdata_G_current[0],initdata_G_current[1]);
			series_G_current.setMarker(SeriesMarkers.NONE);
			XYSeries series_C_temp = chart.addSeries("C_temp", initdata_C_temp[0],initdata_C_temp[1]);
			series_C_temp.setMarker(SeriesMarkers.NONE);
			XYSeries series_T_temp = chart.addSeries("T_temp", initdata_T_temp[0],initdata_T_temp[1]);
			series_T_temp.setMarker(SeriesMarkers.NONE);
			XYSeries series_OilTemp = chart.addSeries("OilTemp", initdata_OilTemp[0],initdata_OilTemp[1]);
			series_OilTemp.setMarker(SeriesMarkers.NONE);
			XYSeries series_GB_temp = chart.addSeries("GB_temp", initdata_GB_temp[0],initdata_GB_temp[1]);
			series_GB_temp.setMarker(SeriesMarkers.NONE);
			XYSeries series_G_speed = chart.addSeries("G_speed", initdata_G_speed[0],initdata_G_speed[1]);
			series_G_speed.setMarker(SeriesMarkers.NONE);
			XYSeries series_Conv_temp = chart.addSeries("Conv_temp", initdata_Conv_temp[0],initdata_Conv_temp[1]);
			series_Conv_temp.setMarker(SeriesMarkers.NONE);
			XYSeries series_R_speed = chart.addSeries("R_speed", initdata_R_speed[0],initdata_R_speed[1]);
			series_R_speed.setMarker(SeriesMarkers.NONE);
			XYSeries series_R_Pangle = chart.addSeries("R_Pangle", initdata_R_Pangle[0],initdata_R_Pangle[1]);
			series_R_Pangle.setMarker(SeriesMarkers.NONE);

			final SwingWrapper<XYChart> sw = new SwingWrapper<XYChart>(chart);
			sw.displayChart();
			
			/*
			 * All the streams generated by the Stream Generator sub-module of
			 * the Translation module. 
			 */
			
			SensorsStreamer Stream_C_Wtemp = new SensorsStreamer("Stream_S_C_Wtemp",ns,"C_Wtemp",6,50,90,ontology,factory,data_C_Wtemp,chart,sw);
			SensorsStreamer Stream_TG_temp = new SensorsStreamer("Stream_S_TG_temp",ns,"TG_temp",6,30,40,ontology,factory,data_TG_temp,chart,sw);
			SensorsStreamer Stream_G_temp = new SensorsStreamer("Stream_S_G_temp",ns,"G_temp",6,40,50,ontology,factory,data_G_temp,chart,sw);
			SensorsStreamer Stream_P_temp = new SensorsStreamer("Stream_S_P_temp",ns,"P_temp",6,25,50,ontology,factory,data_P_temp,chart,sw);
			SensorsStreamer Stream_E_temp = new SensorsStreamer("Stream_S_E_temp",ns,"E_temp",6,15,30,ontology,factory,data_E_temp,chart,sw);
			SensorsStreamer Stream_PowerOutput = new SensorsStreamer("Stream_S_PowerOutput",ns,"PowerOutput",6,100,2100,ontology,factory,data_PowerOutput,chart,sw);
			SensorsStreamer Stream_G_current = new SensorsStreamer("Stream_S_G_current",ns,"G_current",6,700,1000,ontology,factory,data_G_current,chart,sw);
			SensorsStreamer Stream_C_temp = new SensorsStreamer("Stream_S_C_temp",ns,"C_temp",6,30,50,ontology,factory,data_C_temp,chart,sw);
			SensorsStreamer Stream_T_temp = new SensorsStreamer("Stream_S_T_temp",ns,"T_temp",6,35,55,ontology,factory,data_T_temp,chart,sw);
			SensorsStreamer Stream_OilTemp = new SensorsStreamer("Stream_S_OilTemp",ns,"OilTemp",6,30,70,ontology,factory,data_OilTemp,chart,sw);
			SensorsStreamer Stream_GB_temp = new SensorsStreamer("Stream_S_GB_temp",ns,"GB_temp",6,30,70,ontology,factory,data_GB_temp,chart,sw);
			SensorsStreamer Stream_G_speed = new SensorsStreamer("Stream_S_G_speed",ns,"G_speed",6,400,600,ontology,factory,data_G_speed,chart,sw);
			SensorsStreamer Stream_Conv_temp = new SensorsStreamer("Stream_S_Conv_temp",ns,"Conv_temp",6,50,90,ontology,factory,data_Conv_temp,chart,sw);
			SensorsStreamer Stream_R_speed = new SensorsStreamer("Stream_S_R_speed",ns,"R_speed",6,50,300,ontology,factory,data_R_speed,chart,sw);
			SensorsStreamer Stream_R_Pangle = new SensorsStreamer("Stream_S_R_Pangle",ns,"R_Pangle",6,3,10,ontology,factory,data_R_Pangle,chart,sw);

			//Register streams in the engine
			engine.registerStream(Stream_C_Wtemp);
			engine.registerStream(Stream_TG_temp);
			engine.registerStream(Stream_G_temp);
			engine.registerStream(Stream_P_temp);
			engine.registerStream(Stream_E_temp);
			engine.registerStream(Stream_PowerOutput);
			engine.registerStream(Stream_G_current);
			engine.registerStream(Stream_C_temp);
			engine.registerStream(Stream_T_temp);
			engine.registerStream(Stream_OilTemp);
			engine.registerStream(Stream_GB_temp);
			engine.registerStream(Stream_G_speed);
			engine.registerStream(Stream_Conv_temp);
			engine.registerStream(Stream_R_speed);
			engine.registerStream(Stream_R_Pangle);

			Thread Stream_C_Wtemp_Thread = new Thread(Stream_C_Wtemp);
			Thread Stream_TG_temp_Thread = new Thread(Stream_TG_temp);
			Thread Stream_G_temp_Thread = new Thread(Stream_G_temp);
			Thread Stream_P_temp_Thread = new Thread(Stream_P_temp);
			Thread Stream_E_temp_Thread = new Thread(Stream_E_temp);
			Thread Stream_PowerOutput_Thread = new Thread(Stream_PowerOutput);
			Thread Stream_G_current_Thread = new Thread(Stream_G_current);
			Thread Stream_C_temp_Thread = new Thread(Stream_C_temp);
			Thread Stream_T_temp_Thread = new Thread(Stream_T_temp);
			Thread Stream_OilTemp_Thread = new Thread(Stream_OilTemp);
			Thread Stream_GB_temp_Thread = new Thread(Stream_GB_temp);
			Thread Stream_G_speed_Thread = new Thread(Stream_G_speed);
			Thread Stream_Conv_temp_Thread = new Thread(Stream_Conv_temp);
			Thread Stream_R_speed_Thread = new Thread(Stream_R_speed);
			Thread Stream_R_Pangle_Thread = new Thread(Stream_R_Pangle);

			/*
			 * Register all the queries to the Stream Reasoner sub-module of
			 * the Temporal Relations module.
			 */
			CsparqlQueryResultProxy c_S1 = engine.registerQuery(queryS1, false);
			CsparqlQueryResultProxy c_S2 = engine.registerQuery(queryS2, false);
			CsparqlQueryResultProxy c_S3 = engine.registerQuery(queryS3, false);
			CsparqlQueryResultProxy c_S4 = engine.registerQuery(queryS4, false);
			CsparqlQueryResultProxy c_S5 = engine.registerQuery(queryS5, false);
			CsparqlQueryResultProxy c_S6 = engine.registerQuery(queryS6, false);
			CsparqlQueryResultProxy c_S7 = engine.registerQuery(queryS7, false);
			CsparqlQueryResultProxy c_S8 = engine.registerQuery(queryS8, false);
			CsparqlQueryResultProxy c_S9 = engine.registerQuery(queryS9, false);
			CsparqlQueryResultProxy c_S10 = engine.registerQuery(queryS10, false);
			CsparqlQueryResultProxy c_S11 = engine.registerQuery(queryS11, false);
			CsparqlQueryResultProxy c_S12 = engine.registerQuery(queryS12, false);
			CsparqlQueryResultProxy c_S13 = engine.registerQuery(queryS13, false);
			CsparqlQueryResultProxy c_S14 = engine.registerQuery(queryS14, false);

			/*
			 * Attach a result consumer to the query result proxy to print the results on the console
			 * and to modify the COInd4 ontology.
			 */
			c_S1.addObserver(new ConsoleFormatter("S1",ns,ontology,factory,manager));	
			c_S2.addObserver(new ConsoleFormatter("S2",ns,ontology,factory,manager));	
			c_S3.addObserver(new ConsoleFormatter("S3",ns,ontology,factory,manager));	
			c_S4.addObserver(new ConsoleFormatter("S4",ns,ontology,factory,manager));	
			c_S5.addObserver(new ConsoleFormatter("S5",ns,ontology,factory,manager));	
			c_S6.addObserver(new ConsoleFormatter("S6",ns,ontology,factory,manager));	
			c_S7.addObserver(new ConsoleFormatter("S7",ns,ontology,factory,manager));	
			c_S8.addObserver(new ConsoleFormatter("S8",ns,ontology,factory,manager));	
			c_S9.addObserver(new ConsoleFormatter("S9",ns,ontology,factory,manager));	
			c_S10.addObserver(new ConsoleFormatter("S10",ns,ontology,factory,manager));	
			c_S11.addObserver(new ConsoleFormatter("S11",ns,ontology,factory,manager));	
			c_S12.addObserver(new ConsoleFormatter("S12",ns,ontology,factory,manager));	
			c_S13.addObserver(new ConsoleFormatter("S13",ns,ontology,factory,manager));	
			c_S14.addObserver(new ConsoleFormatter("S14",ns,ontology,factory,manager));	

			//Start data streams
			Stream_C_Wtemp_Thread.start();
			Stream_TG_temp_Thread.start();
			Stream_G_temp_Thread.start();
			Stream_P_temp_Thread.start();
			Stream_E_temp_Thread.start();
			Stream_PowerOutput_Thread.start();
			Stream_G_current_Thread.start();
			Stream_C_temp_Thread.start();
			Stream_T_temp_Thread.start();
			Stream_OilTemp_Thread.start();
			Stream_GB_temp_Thread.start();
			Stream_G_speed_Thread.start();
			Stream_Conv_temp_Thread.start();
			Stream_R_speed_Thread.start();
			Stream_R_Pangle_Thread.start();

		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	private static double[][] getArrX(double phase, double[] values) {
		double[] xData = new double[50];
		double[] yData = new double[50];
		for (int i = 0; i < xData.length; i++) {
			xData[i] = phase+i;
			int index=(int) (phase+i);
			yData[i] = values[index];
		}
		return new double[][] { xData, yData };
	}

}


