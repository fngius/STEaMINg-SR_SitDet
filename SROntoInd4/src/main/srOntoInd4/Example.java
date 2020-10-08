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

import com.hp.hpl.jena.sparql.engine.binding.Binding;
import com.hp.hpl.jena.vocabulary.RDF;

import eu.larkc.csparql.cep.api.RdfStream;
import eu.larkc.csparql.common.RDFTable;
import eu.larkc.csparql.common.utils.CsparqlUtils;
import eu.larkc.csparql.common.utils.ReasonerChainingType;
//import eu.larkc.csparql.core.engine.ConsoleFormatter;
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

			//create a new instance of the api manager
			//RSP_services_csparql_API api = new RSP_services_csparql_API("http://localhost:8175");
			//Register new stream in the engine
			//api.registerStream("http://streamreasoning.org/streams/rfs");
			//Thread rfsThread = new Thread(rfs);
			//Register new query in the engine
			//String queryURI = api.registerQuery("IsInFs", queryBody);
			//Attach a result consumer to the query result proxy to print the results on the console
			//api.addObserver(queryURI, "http://localhost:8178/results");
			//Start the thread that put the triples in the engine
			//rfsThread.start();


			//Create csparql engine instance
			CsparqlEngineImpl engine = new CsparqlEngineImpl();
			//Initialize the engine instance
			//The initialization creates the static engine (SPARQL) and the stream engine (CEP)
			engine.initialize(true);

			// put static model
			//engine.putStaticNamedModel("http://streamreasoning.org/larkc/csparql/LBSMA-static-k.rdf", "http://streamreasoning.org/larkc/csparql/LBSMA-static-k.rdf");
			//engine.putStaticNamedModel("http://streamreasoning.org/roomConnection",CsparqlUtils.serializeRDFFile("/home/franco/Repositories/SR-OntoInd4/SROntoInd4/examples_files/ex.rdf"));

			engine.putStaticNamedModel("http://streamreasoning.org/ContextOntology-COInd4",CsparqlUtils.serializeRDFFile("/home/franco/Repositories/SR-OntoInd4/SROntoInd4/ContextOntology-COInd4.owl"));
			
			//String fileOntology = "/home/franco/Repositories/OntoInd4/NEWONTOLOGY.owl";
			String fileOntology = "/home/franco/Repositories/SR-OntoInd4/SROntoInd4/ContextOntology-COInd4.owl";
			
			String queryS1 = "REGISTER QUERY S1detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_G_current> [RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_C_temp> 		[RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_T_temp> 		[RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_OilTemp> 	[RANGE 20s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 						:isPartOf 				?pl . "
			+ "	?m 						sosa:hosts				sosa:S_G_current . "
			+ "	:S_G_current 	:madeObservation 	?o1 . "
			+ "	?o1 					:hasSimpleResult 	?v1 . "
			+ "	?m 						sosa:hosts 				sosa:S_C_temp . "
			+ "	:S_C_temp 		:madeObservation 	?o2 "
			+ "	?o2						:hasSimpleResult 	?v2 . "
			+ "	?m 						sosa:hosts 				sosa:S_T_temp . "
			+ "	:S_T_temp 		:madeObservation 	?o3 . "
			+ "	?o3 					:hasSimpleResult 	?v3 . "
			+ "	?m 						sosa:hosts 				sosa:S_OilTemp . "
			+ "	:S_OilTemp 		:madeObservation 	?o4 . "
			+ "	?o4 					:hasSimpleResult 	?v4 . "
			+ " FILTER ( "
			+ "		?v1 > 800.0 && "
			+ "		?v2 > 40.0  && "
			+ "		?v3 > 45.0  && "
			+ "		?v4 > 40.0 ) . "
			+ "} ";

		String queryS2 = "REGISTER QUERY S2detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_G_current> [RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_C_temp> 		[RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_T_temp> 		[RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_OilTemp> 	[RANGE 20s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 						:isPartOf 				?pl . "
			+ "	?m 						sosa:hosts				sosa:S_G_current . "
			+ "	:S_G_current 	:madeObservation 	?o1 . "
			+ "	?o1 					:hasSimpleResult 	?v1 . "
			+ "	?m 						sosa:hosts 				sosa:S_C_temp . "
			+ "	:S_C_temp 		:madeObservation 	?o2 "
			+ "	?o2						:hasSimpleResult 	?v2 . "
			+ "	?m 						sosa:hosts 				sosa:S_T_temp . "
			+ "	:S_T_temp 		:madeObservation 	?o3 . "
			+ "	?o3 					:hasSimpleResult 	?v3 . "
			+ "	?m 						sosa:hosts 				sosa:S_OilTemp . "
			+ "	:S_OilTemp 		:madeObservation 	?o4 . "
			+ "	?o4 					:hasSimpleResult 	?v4 . "
			+ " FILTER ( "
			+ "		?v1 > 800.0 && "
			+ "		?v2 > 40.0  && "
			+ "		?v3 > 45.0  && "
			+ "		?v4 > 60.0 ) . "
			+ "} ";
		
		String queryS3 = "REGISTER QUERY S3detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_P_temp> 	[RANGE 25s STEPS 5s] "
			+ "FROM STREAM <Stream_S_GB_temp> [RANGE 25s STEPS 5s] "
			+ "FROM STREAM <Stream_S_G_speed> [RANGE 25s STEPS 5s] "
			+ "FROM STREAM <Stream_S_E_Temp> 	[RANGE 25s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 						:isPartOf 				?pl . "
			+ "	?m 						sosa:hosts				sosa:S_P_temp . "
			+ "	:S_P_temp		 	:madeObservation 	?o1 . "
			+ "	?o1 					:hasSimpleResult 	?v1 . "
			+ "	?m 						sosa:hosts 				sosa:S_GB_temp . "
			+ "	:S_GB_temp 		:madeObservation 	?o2 "
			+ "	?o2						:hasSimpleResult 	?v2 . "
			+ "	?m 						sosa:hosts 				sosa:S_G_speed . "
			+ "	:S_G_speed 		:madeObservation 	?o3 . "
			+ "	?o3 					:hasSimpleResult 	?v3 . "
			+ "	?m 						sosa:hosts 				sosa:S_E_Temp . "
			+ "	:S_E_Temp 		:madeObservation 	?o4 . "
			+ "	?o4 					:hasSimpleResult 	?v4 . "
			+ " FILTER ( "
			+ "		?v1 < 35.0   && "
			+ "		?v2 > 40.0   && "
			+ "		?v3 < 500.0  && "
			+ "		?v4 < 25.0 ) . "
			+ "} ";
		
		String queryS4 = "REGISTER QUERY S4detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_P_temp> 	[RANGE 25s STEPS 5s] "
			+ "FROM STREAM <Stream_S_GB_temp> [RANGE 25s STEPS 5s] "
			+ "FROM STREAM <Stream_S_G_speed> [RANGE 25s STEPS 5s] "
			+ "FROM STREAM <Stream_S_E_Temp> 	[RANGE 25s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 						:isPartOf 				?pl . "
			+ "	?m 						sosa:hosts				sosa:S_P_temp . "
			+ "	:S_P_temp		 	:madeObservation 	?o1 . "
			+ "	?o1 					:hasSimpleResult 	?v1 . "
			+ "	?m 						sosa:hosts 				sosa:S_GB_temp . "
			+ "	:S_GB_temp 		:madeObservation 	?o2 "
			+ "	?o2						:hasSimpleResult 	?v2 . "
			+ "	?m 						sosa:hosts 				sosa:S_G_speed . "
			+ "	:S_G_speed 		:madeObservation 	?o3 . "
			+ "	?o3 					:hasSimpleResult 	?v3 . "
			+ "	?m 						sosa:hosts 				sosa:S_E_Temp . "
			+ "	:S_E_Temp 		:madeObservation 	?o4 . "
			+ "	?o4 					:hasSimpleResult 	?v4 . "
			+ " FILTER ( "
			+ "		?v1 < 35.0   && "
			+ "		?v2 > 60.0   && "
			+ "		?v3 < 500.0  && "
			+ "		?v4 < 25.0 ) . "
			+ "} ";
		
		String queryS5 = "REGISTER QUERY S5detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_P_temp> 	[RANGE 25s STEPS 5s] "
			+ "FROM STREAM <Stream_S_GB_temp> [RANGE 25s STEPS 5s] "
			+ "FROM STREAM <Stream_S_G_speed> [RANGE 25s STEPS 5s] "
			+ "FROM STREAM <Stream_S_E_Temp> 	[RANGE 25s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 						:isPartOf 				?pl . "
			+ "	?m 						sosa:hosts				sosa:S_P_temp . "
			+ "	:S_P_temp		 	:madeObservation 	?o1 . "
			+ "	?o1 					:hasSimpleResult 	?v1 . "
			+ "	?m 						sosa:hosts 				sosa:S_GB_temp . "
			+ "	:S_GB_temp 		:madeObservation 	?o2 "
			+ "	?o2						:hasSimpleResult 	?v2 . "
			+ "	?m 						sosa:hosts 				sosa:S_G_speed . "
			+ "	:S_G_speed 		:madeObservation 	?o3 . "
			+ "	?o3 					:hasSimpleResult 	?v3 . "
			+ "	?m 						sosa:hosts 				sosa:S_E_Temp . "
			+ "	:S_E_Temp 		:madeObservation 	?o4 . "
			+ "	?o4 					:hasSimpleResult 	?v4 . "
			+ " FILTER ( "
			+ "		?v1 > 40.0   && "
			+ "		?v2 > 60.0   && "
			+ "		?v3 < 500.0  && "
			+ "		?v4 < 25.0 ) . "
			+ "} ";

		String queryS6 = "REGISTER QUERY S6detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_C_Wtemp> [RANGE 15s STEPS 5s] "
			+ "FROM STREAM <Stream_S_TG_temp> [RANGE 15s STEPS 5s] "
			+ "FROM STREAM <Stream_S_G_temp> 	[RANGE 15s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 					:isPartOf 				?pl . "
			+ "	?m 					sosa:hosts				sosa:S_C_Wtemp . "
			+ "	:S_C_Wtemp 	:madeObservation 	?o1 . "
			+ "	?o1 				:hasSimpleResult 	?v1 . "
			+ "	?m 					sosa:hosts 				sosa:S_TG_temp . "
			+ "	:S_TG_temp 	:madeObservation 	?o2 "
			+ "	?o2					:hasSimpleResult 	?v2 . "
			+ "	?m 					sosa:hosts 				sosa:S_G_temp . "
			+ "	:S_G_temp 	:madeObservation 	?o3 . "
			+ "	?o3 				:hasSimpleResult 	?v3 . "
			+ " FILTER ( "
			+ "		?v1 > 60.0 && "
			+ "		?v2 < 35.0 && "
			+ "		?v3 > 45.0 ) . "
			+ "} ";

		String queryS7 = "REGISTER QUERY S7detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_C_Wtemp> [RANGE 15s STEP 5s] "
			+ "FROM STREAM <Stream_S_TG_temp> [RANGE 15s STEP 5s] "
			+ "FROM STREAM <Stream_S_G_temp> 	[RANGE 15s STEP 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "{ ?m         :isPartOf        ?pl ."
			+ "  ?m         sosa:hosts       sosa:S_C_Wtemp ." 
			+	"  :S_C_Wtemp :madeObservation ?o1 ."
			+ "  ?o1        :hasSimpleResult ?v1 ."
			+ "  ?m         sosa:hosts       sosa:S_TG_temp ."
			+ "  :S_TG_temp :madeObservation ?o2 ."
			+ "  ?o2        :hasSimpleResult ?v2 ."
			+ "  ?m         sosa:hosts       sosa:S_G_temp ."
			+ "  :S_G_temp  :madeObservation ?o3 ."
			+ "  ?o3        :hasSimpleResult ?v3 ."
			+ " FILTER ( "
			+ "   ?v1 > 0.0  && ?v2 > 0.0 && ?v3 > 0.0 ) . }"
			//+ "		?v1 > 80.0 && "
			//+ "		?v2 < 35.0 && "
			//+ "		?v3 > 45.0 ) . "
			+ "} ";
		
		String queryS8 = "REGISTER QUERY S8detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_P_temp> 		[RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_TG_temp> 	[RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_Conv_temp> [RANGE 20s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 						:isPartOf 				?pl . "
			+ "	?m 						sosa:hosts				sosa:S_P_temp . "
			+ "	:S_P_Wtemp 		:madeObservation 	?o1 . "
			+ "	?o1 					:hasSimpleResult 	?v1 . "
			+ "	?m 						sosa:hosts 				sosa:S_TG_temp . "
			+ "	:S_TG_temp 		:madeObservation 	?o2 "
			+ "	?o2						:hasSimpleResult 	?v2 . "
			+ "	?m 						sosa:hosts 				sosa:S_Conv_temp . "
			+ "	:S_Conv_temp 	:madeObservation 	?o3 . "
			+ "	?o3 					:hasSimpleResult 	?v3 . "
			+ " FILTER ( "
			+ "		?v1 < 35.0 && "
			+ "		?v2 < 35.0 && "
			+ "		?v3 > 60.0 ) . "
			+ "} ";
		
		String queryS9 = "REGISTER QUERY S9detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_P_temp> 		[RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_TG_temp> 	[RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_Conv_temp> [RANGE 20s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 						:isPartOf 				?pl . "
			+ "	?m 						sosa:hosts				sosa:S_P_temp . "
			+ "	:S_P_Wtemp 		:madeObservation 	?o1 . "
			+ "	?o1 					:hasSimpleResult 	?v1 . "
			+ "	?m 						sosa:hosts 				sosa:S_TG_temp . "
			+ "	:S_TG_temp 		:madeObservation 	?o2 "
			+ "	?o2						:hasSimpleResult 	?v2 . "
			+ "	?m 						sosa:hosts 				sosa:S_Conv_temp . "
			+ "	:S_Conv_temp 	:madeObservation 	?o3 . "
			+ "	?o3 					:hasSimpleResult 	?v3 . "
			+ " FILTER ( "
			+ "		?v1 < 35.0 && "
			+ "		?v2 < 35.0 && "
			+ "		?v3 > 80.0 ) . "
			+ "} ";

		String queryS10 = "REGISTER QUERY S10detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_C_Wtemp> 	[RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_TG_temp> 	[RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_Conv_temp> [RANGE 20s STEPS 5s] "
			+ "FROM STREAM <Stream_S_G_temp> 		[RANGE 20s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 						:isPartOf 				?pl . "
			+ "	?m 						sosa:hosts				sosa:S_C_Wtemp . "
			+ "	:S_P_Wtemp 		:madeObservation 	?o1 . "
			+ "	?o1 					:hasSimpleResult 	?v1 . "
			+ "	?m 						sosa:hosts 				sosa:S_TG_temp . "
			+ "	:S_TG_temp 		:madeObservation 	?o2 "
			+ "	?o2						:hasSimpleResult 	?v2 . "
			+ "	?m 						sosa:hosts 				sosa:S_Conv_temp . "
			+ "	:S_Conv_temp 	:madeObservation 	?o3 . "
			+ "	?o3 					:hasSimpleResult 	?v3 . "
			+ "	?m 						sosa:hosts 				sosa:S_G_temp . "
			+ "	:S_G_temp 		:madeObservation 	?o4 . "
			+ "	?o4 					:hasSimpleResult 	?v4 . "
			+ " FILTER ( "
			+ "		?v1 > 80.0 && "
			+ "		?v2 < 35.0 && "
			+ "		?v3 > 60.0 && "
			+ "		?v4 < 45.0 ) . "
			+ "} ";

		String queryS11 = "REGISTER QUERY S11detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_PowerOutput> [RANGE 30s STEPS 5s] "
			+ "FROM STREAM <Stream_S_R_speed> 		[RANGE 30s STEPS 5s] "
			+ "FROM STREAM <Stream_S_R_Pangle> 		[RANGE 30s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 							:isPartOf 				?pl . "
			+ "	?m 							sosa:hosts				sosa:S_PowerOutput . "
			+ "	:S_PowerOutput 	:madeObservation 	?o1 . "
			+ "	?o1 						:hasSimpleResult 	?v1 . "
			+ "	?m 							sosa:hosts 				sosa:S_R_speed . "
			+ "	:S_R_speed 			:madeObservation 	?o2 "
			+ "	?o2							:hasSimpleResult 	?v2 . "
			+ "	?m 							sosa:hosts 				sosa:S_R_Pangle . "
			+ "	:S_R_Pangle 		:madeObservation 	?o3 . "
			+ "	?o3 						:hasSimpleResult 	?v3 . "
			+ " FILTER ( "
			+ "		?v1 > 2000.0 && "
			+ "		?v2 < 200.0 && "
			+ "		?v3 < 5.0 ) . "
			+ "} ";
		
		String queryS12 = "REGISTER QUERY S12detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_PowerOutput> [RANGE 30s STEPS 5s] "
			+ "FROM STREAM <Stream_S_R_speed> 		[RANGE 30s STEPS 5s] "
			+ "FROM STREAM <Stream_S_R_Pangle> 		[RANGE 30s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 							:isPartOf 				?pl . "
			+ "	?m 							sosa:hosts				sosa:S_PowerOutput . "
			+ "	:S_PowerOutput 	:madeObservation 	?o1 . "
			+ "	?o1 						:hasSimpleResult 	?v1 . "
			+ "	?m 							sosa:hosts 				sosa:S_R_speed . "
			+ "	:S_R_speed 			:madeObservation 	?o2 "
			+ "	?o2							:hasSimpleResult 	?v2 . "
			+ "	?m 							sosa:hosts 				sosa:S_R_Pangle . "
			+ "	:S_R_Pangle 		:madeObservation 	?o3 . "
			+ "	?o3 						:hasSimpleResult 	?v3 . "
			+ " FILTER ( "
			+ "		?v1 > 2000.0 && "
			+ "		?v2 < 100.0 && "
			+ "		?v3 < 5.0 ) . "
			+ "} ";
		
		String queryS13 = "REGISTER QUERY S13detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_PowerOutput> [RANGE 35s STEPS 5s] "
			+ "FROM STREAM <Stream_S_R_speed> 		[RANGE 35s STEPS 5s] "
			+ "FROM STREAM <Stream_S_R_Pangle> 		[RANGE 35s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 							:isPartOf 				?pl . "
			+ "	?m 							sosa:hosts				sosa:S_PowerOutput . "
			+ "	:S_PowerOutput 	:madeObservation 	?o1 . "
			+ "	?o1 						:hasSimpleResult 	?v1 . "
			+ "	?m 							sosa:hosts 				sosa:S_R_speed . "
			+ "	:S_R_speed 			:madeObservation 	?o2 "
			+ "	?o2							:hasSimpleResult 	?v2 . "
			+ "	?m 							sosa:hosts 				sosa:S_R_Pangle . "
			+ "	:S_R_Pangle 		:madeObservation 	?o3 . "
			+ "	?o3 						:hasSimpleResult 	?v3 . "
			+ " FILTER ( "
			+ "		?v1 < 500.0 && "
			+ "		?v2 < 200.0 && "
			+ "		?v3 < 5.0 ) . "
			+ "} ";
		
			String queryS14 = "REGISTER QUERY S14detection AS "
			+ "PREFIX : <http://semanticweb.org/STEaMINg/ContextOntology-COInd4#> "
			+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
			+ "SELECT ?m ?pl "
			+ "FROM STREAM <Stream_S_PowerOutput> [RANGE 35s STEPS 5s] "
			+ "FROM STREAM <Stream_S_R_speed> 		[RANGE 35s STEPS 5s] "
			+ "FROM STREAM <Stream_S_R_Pangle> 		[RANGE 35s STEPS 5s] "
			+ "FROM <http://streamreasoning.org/ContextOntology-COInd4> "
			+ "WHERE { "
			+ "	?m 							:isPartOf 				?pl . "
			+ "	?m 							sosa:hosts				sosa:S_PowerOutput . "
			+ "	:S_PowerOutput 	:madeObservation 	?o1 . "
			+ "	?o1 						:hasSimpleResult 	?v1 . "
			+ "	?m 							sosa:hosts 				sosa:S_R_speed . "
			+ "	:S_R_speed 			:madeObservation 	?o2 "
			+ "	?o2							:hasSimpleResult 	?v2 . "
			+ "	?m 							sosa:hosts 				sosa:S_R_Pangle . "
			+ "	:S_R_Pangle 		:madeObservation 	?o3 . "
			+ "	?o3 						:hasSimpleResult 	?v3 . "
			+ " FILTER ( "
			+ "		?v1 < 200.0 && "
			+ "		?v2 < 200.0 && "
			+ "		?v3 < 5.0 ) . "
			+ "} ";

		//+ "CONSTRUCT { [] a :situationCODE1234 ; :hasObservation ?o1 ; :hasObservation ?o2 . } "
		//+ "f:timestamp(:sensorTM1,:madeObservation,?o1) < f:timestamp(?s1,:madeObservation,?o2)"

			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			OWLDataFactory factory = manager.getOWLDataFactory();
			String ontologyURI = "http://semanticweb.org/STEaMINg/ContextOntology-COInd4";
			String ns = ontologyURI + "#";
			final OWLOntology ontology = manager.loadOntologyFromOntologyDocument(new File(fileOntology));
			
			SensorsStreamer Stream_C_Wtemp = new SensorsStreamer("Stream_S_C_Wtemp",ns,"C_Wtemp",2,ontology,factory);
			SensorsStreamer Stream_TG_temp = new SensorsStreamer("Stream_S_TG_temp",ns,"TG_temp",9,ontology,factory);
			SensorsStreamer Stream_G_temp = new SensorsStreamer("Stream_S_G_temp",ns,"G_temp",9,ontology,factory);
			/*
			SensorsStreamer Stream_P_temp 	 	 = new SensorsStreamer("Stream_S_P_temp",ns,"P_temp",9,ontology,factory);
			SensorsStreamer Stream_E_temp  		 = new SensorsStreamer("Stream_S_E_temp",ns,"E_temp",9,ontology,factory);
			SensorsStreamer Stream_PowerOutput = new SensorsStreamer("Stream_S_PowerOutput",ns,"PowerOutput",9,ontology,factory);
			SensorsStreamer Stream_G_current 	 = new SensorsStreamer("Stream_S_G_current",ns,"G_current",9,ontology,factory);
			SensorsStreamer Stream_C_temp 		 = new SensorsStreamer("Stream_S_C_temp",ns,"C_temp",9,ontology,factory);
			SensorsStreamer Stream_T_temp 		 = new SensorsStreamer("Stream_S_T_temp",ns,"T_temp",9,ontology,factory);
			SensorsStreamer Stream_OilTemp 		 = new SensorsStreamer("Stream_S_OilTemp",ns,"OilTemp",9,ontology,factory);
			SensorsStreamer Stream_GB_temp 	   = new SensorsStreamer("Stream_S_GB_temp",ns,"GB_temp",9,ontology,factory);
			SensorsStreamer Stream_G_speed 		 = new SensorsStreamer("Stream_S_G_speed",ns,"G_speed",9,ontology,factory);
			SensorsStreamer Stream_Conv_temp 	 = new SensorsStreamer("Stream_S_Conv_temp",ns,"Conv_temp",9,ontology,factory);
			SensorsStreamer Stream_R_speed 		 = new SensorsStreamer("Stream_S_R_speed",ns,"R_speed",9,ontology,factory);
			SensorsStreamer Stream_R_Pangle 	 = new SensorsStreamer("Stream_S_R_Pangle",ns,"R_Pangle",9,ontology,factory);
			*/

			//Register new streams in the engine
			engine.registerStream(Stream_C_Wtemp);
			engine.registerStream(Stream_TG_temp);
			engine.registerStream(Stream_G_temp);
			/*
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
			*/

			Thread Stream_C_Wtemp_Thread = new Thread(Stream_C_Wtemp);
			Thread Stream_TG_temp_Thread = new Thread(Stream_TG_temp);
			Thread Stream_G_temp_Thread = new Thread(Stream_G_temp);
			/*
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
			*/

			//Register new query in the engine
			/*
			CsparqlQueryResultProxy c_S1 = engine.registerQuery(queryS1, false);
			CsparqlQueryResultProxy c_S2 = engine.registerQuery(queryS2, false);
			CsparqlQueryResultProxy c_S3 = engine.registerQuery(queryS3, false);
			CsparqlQueryResultProxy c_S4 = engine.registerQuery(queryS4, false);
			CsparqlQueryResultProxy c_S5 = engine.registerQuery(queryS5, false);
			*/
			//CsparqlQueryResultProxy c_S6 = engine.registerQuery(queryS6, false);
			CsparqlQueryResultProxy c_S7 = engine.registerQuery(queryS7, false);
			/*
			CsparqlQueryResultProxy c_S8 = engine.registerQuery(queryS8, false);
			CsparqlQueryResultProxy c_S9 = engine.registerQuery(queryS9, false);
			CsparqlQueryResultProxy c_S10 = engine.registerQuery(queryS10, false);
			CsparqlQueryResultProxy c_S11 = engine.registerQuery(queryS11, false);
			CsparqlQueryResultProxy c_S12 = engine.registerQuery(queryS12, false);
			CsparqlQueryResultProxy c_S13 = engine.registerQuery(queryS13, false);
			CsparqlQueryResultProxy c_S14 = engine.registerQuery(queryS14, false);
			*/

			//Attach a result consumer to the query result proxy to print the results on the console
			/*
			c_S1.addObserver(new ConsoleFormatter("S1 DETECTED",ns,ontology,factory));	
			c_S2.addObserver(new ConsoleFormatter("S2 DETECTED",ns,ontology,factory));	
			c_S3.addObserver(new ConsoleFormatter("S3 DETECTED",ns,ontology,factory));	
			c_S4.addObserver(new ConsoleFormatter("S4 DETECTED",ns,ontology,factory));	
			c_S5.addObserver(new ConsoleFormatter("S5 DETECTED",ns,ontology,factory));	
			*/
			//c_S6.addObserver(new ConsoleFormatter("S6",ns,ontology,factory));	
			c_S7.addObserver(new ConsoleFormatter("S7",ns,ontology,factory));	
			/*
			c_S8.addObserver(new ConsoleFormatter("S8 DETECTED",ns,ontology,factory));	
			c_S9.addObserver(new ConsoleFormatter("S9 DETECTED",ns,ontology,factory));	
			c_S10.addObserver(new ConsoleFormatter("S10 DETECTED",ns,ontology,factory));	
			c_S11.addObserver(new ConsoleFormatter("S11 DETECTED",ns,ontology,factory));	
			c_S12.addObserver(new ConsoleFormatter("S12 DETECTED",ns,ontology,factory));	
			c_S13.addObserver(new ConsoleFormatter("S13 DETECTED",ns,ontology,factory));	
			c_S14.addObserver(new ConsoleFormatter("S14 DETECTED",ns,ontology,factory));	
			*/

			//Start streaming data
			Stream_C_Wtemp_Thread.start();
			Stream_TG_temp_Thread.start();
			Stream_G_temp_Thread.start();
			/*
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
			*/

			//engine.updateReasoner(c.getSparqlQueryId(), 
			//CsparqlUtils.fileToString("examples_files/rdfs.rules"), 
			//ReasonerChainingType.FORWARD, 
			//CsparqlUtils.serializeRDFFile("examples_files/tbox.rdf"));

		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

}


