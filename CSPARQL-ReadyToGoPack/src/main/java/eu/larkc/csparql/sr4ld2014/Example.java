package eu.larkc.csparql.sr4ld2014;

import java.awt.geom.GeneralPath;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formattable;
import java.util.Formatter;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.XMLFormatter;

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
import eu.larkc.csparql.core.engine.ConsoleFormatter;
import eu.larkc.csparql.core.engine.CsparqlEngineImpl;
import eu.larkc.csparql.core.engine.CsparqlQueryResultProxy;
import eu.larkc.csparql.core.engine.RDFStreamFormatter;
import eu.larkc.csparql.sr4ld2014.streamer.SensorsStreamer;
import eu.larkc.csparql.sr4ld2014.streamer.SensorsStreamer1;

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
			engine.putStaticNamedModel("http://streamreasoning.org/roomConnection",CsparqlUtils.serializeRDFFile("/home/franco/Repositories/SR-OntoInd4/CSPARQL-ReadyToGoPack/examples_files/ex.rdf"));

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

			String queryBody = "REGISTER QUERY reasoning AS "
					+ "PREFIX :<http://onto#> "
					+ "PREFIX f: <http://larkc.eu/csparql/sparql/jena/ext#> "
					//+ "CONSTRUCT { ?s :isIn ?p } "
					+ "SELECT ?o1 ?o2 "
					+ "FROM STREAM <sensorTM2> [RANGE 5s TUMBLING] "
					+ "FROM STREAM <sensorTM1> [RANGE 5s TUMBLING] "
					+ "WHERE { "
					+ "{ :sensorTM1 :madeObservation ?o1 ." // ?s instead of :sensorTM1 for both cases
					+ " ?o1 :hasSimpleResult ?p . ?o1 :hasTime ?r ."
					//+ " ?o1 :hasTime ?r . "
					+ " ?s1 :madeObservation ?o2 ."
					+ " ?o2 :hasSimpleResult ?p1 ."
					+ " ?o2 :hasTime ?r1 ."
					+ "FILTER (f:timestamp(:sensorTM1,:madeObservation,?o1) < f:timestamp(?s1,:madeObservation,?o2)"
					+ " && ?p > 1 && ?p1 > 2 && ?s1 != :sensorTM1 ). }"
					+ "} ";

			String queryBody1 = "REGISTER QUERY reasoning AS "
					+ "PREFIX :<http://onto#> "
					+ "PREFIX f: <http://larkc.eu/csparql/sparql/jena/ext#> "
					//+ "CONSTRUCT { [] a :situationCODE1234 ; :hasObservation ?o1 ; :hasObservation ?o2 . } "
					+ "SELECT ?o1 ?o2 "
					+ "FROM STREAM <sensorTM2> [RANGE 5s TUMBLING] "
					+ "FROM STREAM <sensorTM1> [RANGE 5s TUMBLING] "
					+ "WHERE { "
					+ "{ :sensorTM1 :madeObservation ?o1 ." // ?s instead of :sensorTM1 for both cases
					+ " ?o1 :hasSimpleResult ?p . ?o1 :hasTime ?r ."
					//+ " ?o1 :hasTime ?r . "
					+ " ?s1 :madeObservation ?o2 ."
					+ " ?o2 :hasSimpleResult ?p1 ."
					+ " ?o2 :hasTime ?r1 ."
					+ "FILTER ("
					//+ "f:timestamp(:sensorTM1,:madeObservation,?o1) < f:timestamp(?s1,:madeObservation,?o2)"
					//+ " && "
					+ "?p > 1 && ?p1 > 2 && ?s1 != :sensorTM1 ). }"
					+ "} ";

			OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
			OWLDataFactory factory = manager.getOWLDataFactory();

			String ontologyURI = "http://onto";
			String ns = ontologyURI + "#";
			String ontologyURISituation = "http://industrySituation.ont";
			String nsSituation = ontologyURISituation + "#";
			String pre_SOSAOnt = "http://www.w3.org/ns/sosa/";

			final OWLOntology ontology = manager.loadOntologyFromOntologyDocument(new File("/home/franco/Repositories/OntoInd4/test.owl"));
			//OWLOntology ontology = manager.createOntology(IRI.create(ontologyURI));

			SensorsStreamer1 streamSTM1 = new SensorsStreamer1("sensorTM1", "http://onto#", 1000L, ontology,factory);
			SensorsStreamer streamSTM2 = new SensorsStreamer("sensorTM2", "http://onto#", 100L,ontology,factory);

			//Register new streams in the engine
			engine.registerStream(streamSTM2);
			engine.registerStream(streamSTM1);

			Thread streamSTM2Thread = new Thread(streamSTM2);
			Thread streamSTM1Thread = new Thread(streamSTM1);

			//Register new query in the engine
			//CsparqlQueryResultProxy c = engine.registerQuery(queryBody, false);
			CsparqlQueryResultProxy c1 = engine.registerQuery(queryBody1, false);

			//Attach a result consumer to the query result proxy to print the results on the console
			//c.addObserver(new ConsoleFormatter());
			//c1.addObserver(new RDFStreamFormatter(iri));
			c1.addObserver(new ConsoleFormatter());


			File file = new File("/home/franco/Repositories/OntoInd4/test_inferred.owl"); 
			
			OWLClass Situation = factory.getOWLClass(IRI.create(nsSituation,"Situation"));
			OWLClass Observation = factory.getOWLClass(IRI.create(pre_SOSAOnt + "Observation"));
			OWLObjectProperty isInSituation = factory.getOWLObjectProperty(IRI.create(ns + "isInSituation"));

			c1.addObserver(new Observer() {
				int i = 0;
				@Override
				public void update(Observable o, Object arg) {
					// TODO Auto-generated method stub
					final RDFTable rdfTable = (RDFTable) arg;
					//final List<Binding> bindings = new ArrayList<>();
					//final String[] vars = rdfTable.getNames().toArray(new String[]{});
					//System.out.println(rdfTable.getJsonSerialization());
					if (rdfTable.size()==0)
						System.out.println("NO RESULT!!!");
					else {
						rdfTable.stream().forEach((t) -> {System.out.println(t.get(0) + " ZZZ "+ t.get(1));});
						rdfTable.stream().forEach((t) -> {
							OWLIndividual ind = factory.getOWLNamedIndividual(IRI.create(ns,"SITUATION1234-"+i));
							OWLClassAssertionAxiom indType = factory.getOWLClassAssertionAxiom(Situation, ind);
							ontology.add(indType);
							OWLIndividual ind1 = factory.getOWLNamedIndividual(IRI.create("",t.get(0)));
							//OWLClassAssertionAxiom indType1 = factory.getOWLClassAssertionAxiom(Observation, ind1);
							//ontology.add(indType1);
							OWLIndividual ind2 = factory.getOWLNamedIndividual(IRI.create("",t.get(1)));
							//OWLClassAssertionAxiom indType2 = factory.getOWLClassAssertionAxiom(Observation, ind2);
							//ontology.add(indType2);
							OWLObjectPropertyAssertionAxiom obs1isInSituation = factory.getOWLObjectPropertyAssertionAxiom(isInSituation, ind1, ind);
							ontology.add(obs1isInSituation);
							OWLObjectPropertyAssertionAxiom obs2isInSituation = factory.getOWLObjectPropertyAssertionAxiom(isInSituation, ind2, ind);
							ontology.add(obs2isInSituation);
							try {
								ontology.saveOntology();
								System.out.println("STREAM SITUAAAAAATION");
							} catch (OWLOntologyStorageException e1) {
								e1.printStackTrace();
							}
						});
						i++;

						OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
						ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();
						OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
						OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);

						List<InferredAxiomGenerator<? extends OWLAxiom>> inferredAxioms = new ArrayList<InferredAxiomGenerator<? extends OWLAxiom>>();
						//inferredAxioms.add(new InferredSubClassAxiomGenerator());
						inferredAxioms.add(new InferredClassAssertionAxiomGenerator());
						//inferredAxioms.add(new InferredDataPropertyCharacteristicAxiomGenerator());
						//inferredAxioms.add(new InferredObjectPropertyCharacteristicAxiomGenerator());
						//inferredAxioms.add(new InferredEquivalentClassAxiomGenerator());
						//inferredAxioms.add(new InferredPropertyAssertionGenerator());
						inferredAxioms.add(new InferredInverseObjectPropertiesAxiomGenerator());         
						inferredAxioms.add(new InferredSubDataPropertyAxiomGenerator());
						inferredAxioms.add(new InferredSubObjectPropertyAxiomGenerator());
						System.out.println("finished adding axiom generators");

						reasoner.precomputeInferences(InferenceType.CLASS_ASSERTIONS);
						
						//				        List<InferredIndividualAxiomGenerator<? extends OWLIndividualAxiom>> individualAxioms= new ArrayList<InferredIndividualAxiomGenerator<? extends OWLIndividualAxiom>>();
						//				        inferredAxioms.addAll(individualAxioms);

						// for writing inferred axioms to the new ontology
						OWLOntology infOnt = null;
						try {
							infOnt = manager.createOntology(IRI.create(ontology.getOntologyID().getOntologyIRI().get()+"_inferred"));
						} catch (OWLOntologyCreationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						// use generator and reasoner to infer some axioms
						System.out.println("Starting to infer");
						InferredOntologyGenerator iog = new InferredOntologyGenerator(reasoner, inferredAxioms);
						//InferredOntologyGenerator iog = new InferredOntologyGenerator(reasoner);

						System.out.println("Inferrence is over");

						System.out.println("Storing the results");
						iog.fillOntology(factory,infOnt);
						System.out.println("Results are stored");
						//long elapsed_time = System.nanoTime()-t0;
						//System.out.println(elapsed_time);

						// save the ontology
						try {
							manager.saveOntology(infOnt, IRI.create(file.toURI()));
						} catch (OWLOntologyStorageException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					//rdfTable.stream().forEach((t) -> {
					//bindings.add(toBinding(vars, t.toString(), "\t"));
					//});
					//sendToWAMP(getString(vars, bindings), c.getSparqlQueryId());
					//appendEventsToStore(getString(vars, bindings),c.getSparqlQueryId());
					//subscribeTopics(query_id, true);
				}
			});


			//Start streaming data
			streamSTM2Thread.start();
			streamSTM1Thread.start();

			//engine.updateReasoner(c.getSparqlQueryId(), 
			//		CsparqlUtils.fileToString("examples_files/rdfs.rules"), 
			//		ReasonerChainingType.FORWARD, 
			//		CsparqlUtils.serializeRDFFile("examples_files/tbox.rdf"));

		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}


}