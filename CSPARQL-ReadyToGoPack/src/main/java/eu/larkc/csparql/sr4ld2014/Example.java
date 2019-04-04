package eu.larkc.csparql.sr4ld2014;

import java.awt.geom.GeneralPath;
import java.util.Formattable;
import java.util.Formatter;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eu.larkc.csparql.common.utils.CsparqlUtils;
import eu.larkc.csparql.common.utils.ReasonerChainingType;
import eu.larkc.csparql.core.engine.ConsoleFormatter;
import eu.larkc.csparql.core.engine.CsparqlEngineImpl;
import eu.larkc.csparql.core.engine.CsparqlQueryResultProxy;
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
			//engine.initialize();
			engine.initialize(true);
			/*String queryBody = "REGISTER STREAM IsInFs AS "
					+ "PREFIX : <http://www.streamreasoning.org/ontologies/sr4ld2014-onto#> "
					+ "CONSTRUCT { ?person :isIn ?room } "
					+ "FROM STREAM <http://streamreasoning.org/streams/fs> [RANGE 10s STEP 1s] "
					+ "WHERE { "
					+ "?person :posts [ :who ?person ; :where ?room ] "
					+ "}";
			*/
			
			String queryBody = "REGISTER QUERY reasoning AS "
					+ "PREFIX :<http://onto#> "
					+ "PREFIX f: <http://larkc.eu/csparql/sparql/jena/ext#> "
					//+ "CONSTRUCT { ?s :isIn ?p } "
					+ "SELECT ?o1 ?o2 "
					//+ "FROM STREAM <http://streamreasoning.org/streams/fb> [RANGE 1s STEP 1s] "
					+ "FROM STREAM <http://streamreasoning.org/streams/sensors> [RANGE 5s STEP 5s] "
					+ "FROM STREAM <http://streamreasoning.org/streams/sensors1> [RANGE 5s STEP 5s] "
					//+ "WHERE { "
					//+ "GRAPH stream1 {"
					//+ "?s2 :madeObservation ?o2"
					//+ "} UNION "
					//+ "GRAPH stream2 {"
					//+ "?s2 :madeObservation ?o2"
					//+ "}"
					+ "WHERE { "
					+ "{ ?s :madeObservation ?o1 ."
					+ " ?o1 :hasSimpleResult ?p ."
					+ " ?o1 :hasTime ?r . "
					+ " ?s1 :madeObservation ?o2 ."
					+ " ?o2 :hasSimpleResult ?p1 ."
					+ " ?o2 :hasTime ?r1 ."
					+ "FILTER (f:timestamp(?s,:madeObservation,?o1) < f:timestamp(?s1,:madeObservation,?o2) && ?p > 1 && ?p1 > 2 && ?s != ?s1 ). }"
					//+ "UNION "  f:timestamp(?s,:madeObservation,?o1) < f:timestamp(?s1,:madeObservation,?o2)
					//+ "{ ?s1 :madeObservation [ :hasSimpleResult ?p1 ; :hasTime ?r1 ]  "
					//+ "FILTER (?p1 > 3 && ?s != ?s1). }"
					+ "} ";

			//FacebookStreamer fb = new FacebookStreamer("http://streamreasoning.org/streams/fb", "http://www.streamreasoning.org/ontologies/sr4ld2014-onto#", 1000L);
			SensorsStreamer1 s1 = new SensorsStreamer1("http://streamreasoning.org/streams/sensors1", "http://onto#", 1000L);
			SensorsStreamer s = new SensorsStreamer("http://streamreasoning.org/streams/sensors", "http://onto#", 10000L);

			//Register new streams in the engine
			engine.registerStream(s);
			engine.registerStream(s1);
			//Thread fbThread = new Thread(fb);
			Thread sThread = new Thread(s);
			Thread s1Thread = new Thread(s1);

			//Register new query in the engine
			CsparqlQueryResultProxy c = engine.registerQuery(queryBody, false);			

			//Attach a result consumer to the query result proxy to print the results on the console
			c.addObserver(new ConsoleFormatter());

			//Start streaming data
			sThread.start();
			s1Thread.start();

			engine.updateReasoner(c.getSparqlQueryId(), CsparqlUtils.fileToString("examples_files/rdfs.rules"), ReasonerChainingType.FORWARD, CsparqlUtils.serializeRDFFile("examples_files/tbox.rdf"));

		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

}