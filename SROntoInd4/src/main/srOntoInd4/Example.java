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

			//Create csparql engine instance
			CsparqlEngineImpl engine = new CsparqlEngineImpl();
			//Initialize the engine instance
			//The initialization creates the static engine (SPARQL) and the stream engine (CEP)
			//engine.initialize(); true for enable timestamp function
			engine.initialize(true);

			// put static model
			//engine.putStaticNamedModel("http://streamreasoning.org/larkc/csparql/LBSMA-static-k.rdf", "http://streamreasoning.org/larkc/csparql/LBSMA-static-k.rdf");
			//engine.putStaticNamedModel("http://streamreasoning.org/roomConnection",CsparqlUtils.serializeRDFFile("/home/franco/Repositories/SR-OntoInd4/SROntoInd4/examples_files/ex.rdf"));

			engine.putStaticNamedModel("http://streamreasoning.org/roomConne",CsparqlUtils.serializeRDFFile("/home/franco/Repositories/OntoInd4/NEWONTOLOGY.owl"));

			//String fileOntology = "/home/franco/Repositories/OntoInd4/test.owl";
			String fileOntology = "/home/franco/Repositories/OntoInd4/NEWONTOLOGY.owl";

			/*
			final String queryBody = "REGISTER QUERY reasoning AS "
					+ "PREFIX :<http://onto#> "
					+ "PREFIX f: <http://larkc.eu/csparql/sparql/jena/ext#> "
					//+ "CONSTRUCT { ?o1 :isInSituation [a :situationCODE1234] } "
					//+ "CONSTRUCT { [] a :situationCODE1234 ; :hasObservation ?o1 ; :hasObservation ?o2 . } "
					+ "SELECT ?o1 ?o2 ?average "
					+ "FROM STREAM <sensorTM2> [RANGE 5s TUMBLING] " //STEP 5s
					+ "FROM STREAM <sensorTM1> [RANGE 5s TUMBLING] "
					+ "FROM <http://streamreasoning.org/roomConnection> "
					+ "WHERE { "
					+ " :sensorTM1 :madeObservation ?o1 ." // ?s instead of :sensorTM1 for both cases
					+ " ?o1 :hasSimpleResult ?p1 ."
					+ " ?o1 :hasTime ?r1 . "
					+ " ?s2 :madeObservation ?o2 ."
					+ "{ SELECT ?s2 ( avg(?p2) AS ?average ) "
					+ "  WHERE { "
					+ "    ?s2 :madeObservation ?o2 ." //
					+ "    ?o2 :hasSimpleResult ?p2 ."
					+ "    ?o2 :hasTime ?r2 ."
					+ "  } "
					+ "  GROUP BY ?s2"
					+ "  HAVING ( avg(?p2) > 2 ) "
					+ "} "
					+ "FILTER ( ?p1 > 2 && ?s2 != :sensorTM1 ) . "
					+ " } ";
			 */

			String queryS6 = "REGISTER QUERY reasoning AS "
					+ "PREFIX : <http://onto#> "
					+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
					+ "PREFIX f: <http://larkc.eu/csparql/sparql/jena/ext#> "
					//+ "CONSTRUCT { [] a :situationCODE1234 ; :hasObservation ?o1 ; :hasObservation ?o2 . } "
					+ "SELECT ?o1 ?o2 ?o3 ?m ?pl "
					+ "FROM STREAM <Stream_C_Wtemp> [RANGE 10s TUMBLING] "
					+ "FROM STREAM <Stream_TG_temp> [RANGE 10s TUMBLING] "
					+ "FROM STREAM <Stream_G_temp>  [RANGE 10s TUMBLING] "
					+ "FROM <http://streamreasoning.org/roomConne> "
					+ "WHERE { "
					+ "{ ?m         :isPartOf        ?pl ."
					+ "  ?m         sosa:hosts       sosa:S_C_Wtemp ." 
					+	"  :S_C_Wtemp :madeObservation ?o1 ."
					+ "  ?o1        :hasSimpleResult ?p1 ."
					+ "  ?m        sosa:hosts       sosa:S_TG_temp ."
					+ "  :S_TG_temp :madeObservation ?o2 ."
					+ "  ?o2        :hasSimpleResult ?p2 ."
					+ "  ?m        sosa:hosts       sosa:S_G_temp ."
					+ "  :S_G_temp  :madeObservation ?o3 ."
					+ "  ?o3        :hasSimpleResult ?p3 ."
					+ "FILTER ("
					//+ "f:timestamp(:sensorTM1,:madeObservation,?o1) < f:timestamp(?s1,:madeObservation,?o2)"
					//+ " && "
					+ "?p1 > 1.0  && ?p2 > 1.0 && ?p3 > 1.0 ). }"
					+ "} ";

					String queryS7 = "REGISTER QUERY reasoning AS "
					+ "PREFIX : <http://onto#> "
					+ "PREFIX sosa: <http://www.w3.org/ns/sosa/> "
					+ "PREFIX f: <http://larkc.eu/csparql/sparql/jena/ext#> "
					//+ "CONSTRUCT { [] a :situationCODE1234 ; :hasObservation ?o1 ; :hasObservation ?o2 . } "
					+ "SELECT ?o1 ?o2 ?o3 ?m ?pl "
					+ "FROM STREAM <Stream_C_Wtemp> [RANGE 10s TUMBLING] "
					+ "FROM STREAM <Stream_TG_temp> [RANGE 10s TUMBLING] "
					+ "FROM STREAM <Stream_G_temp>  [RANGE 10s TUMBLING] "
					+ "FROM <http://streamreasoning.org/roomConne> "
					+ "WHERE { "
					+ "{ ?m         :isPartOf        ?pl ."
					+ "  ?m         sosa:hosts       sosa:S_C_Wtemp ." 
					+	"  :S_C_Wtemp :madeObservation ?o1 ."
					+ "  ?o1        :hasSimpleResult ?p1 ."
					+ "  ?m        sosa:hosts       sosa:S_TG_temp ."
					+ "  :S_TG_temp :madeObservation ?o2 ."
					+ "  ?o2        :hasSimpleResult ?p2 ."
					+ "  ?m        sosa:hosts       sosa:S_G_temp ."
					+ "  :S_G_temp  :madeObservation ?o3 ."
					+ "  ?o3        :hasSimpleResult ?p3 ."
					+ "FILTER ("
					//+ "f:timestamp(:sensorTM1,:madeObservation,?o1) < f:timestamp(?s1,:madeObservation,?o2)"
					//+ " && "
					+ "?p1 > 1.0  && ?p2 > 1.0 && ?p3 > 1.0 ). }"
					+ "} ";

			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			OWLDataFactory factory = manager.getOWLDataFactory();
			String ontologyURI = "http://onto";
			String ns = ontologyURI + "#";
			final OWLOntology ontology = manager.loadOntologyFromOntologyDocument(new File(fileOntology));
			
			SensorsStreamer Stream_C_Wtemp = new SensorsStreamer("Stream_C_Wtemp",ns,"C_Wtemp",9,ontology,factory);
			SensorsStreamer Stream_TG_temp = new SensorsStreamer("Stream_TG_temp",ns,"TG_temp",9,ontology,factory);
			SensorsStreamer Stream_G_temp = new SensorsStreamer("Stream_G_temp",ns,"G_temp",9,ontology,factory);

			//Register new streams in the engine
			engine.registerStream(Stream_C_Wtemp);
			engine.registerStream(Stream_TG_temp);
			engine.registerStream(Stream_G_temp);

			Thread Stream_C_Wtemp_Thread = new Thread(Stream_C_Wtemp);
			Thread Stream_TG_temp_Thread = new Thread(Stream_TG_temp);
			Thread Stream_G_temp_Thread = new Thread(Stream_G_temp);

			//Register new query in the engine
			CsparqlQueryResultProxy c_S6 = engine.registerQuery(queryS6, false);
			CsparqlQueryResultProxy c_S7 = engine.registerQuery(queryS7, false);

			//Attach a result consumer to the query result proxy to print the results on the console
			c_S6.addObserver(new ConsoleFormatter("S6 DETECTED"));	
			c_S7.addObserver(new ConsoleFormatter("S7 DETECTED"));	


			//Start streaming data
			Stream_C_Wtemp_Thread.start();
			Stream_TG_temp_Thread.start();
			Stream_G_temp_Thread.start();

			//engine.updateReasoner(c.getSparqlQueryId(), 
			//CsparqlUtils.fileToString("examples_files/rdfs.rules"), 
			//ReasonerChainingType.FORWARD, 
			//CsparqlUtils.serializeRDFFile("examples_files/tbox.rdf"));

		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

}