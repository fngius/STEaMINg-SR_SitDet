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
			//engine.initialize(); true for enable timestamp function
			engine.initialize(true);
			
			String queryBody = "REGISTER QUERY reasoning AS "
					+ "PREFIX :<http://onto#> "
					+ "PREFIX f: <http://larkc.eu/csparql/sparql/jena/ext#> "
					//+ "CONSTRUCT { ?o1 :isInSituation [a :situationCODE1234] } "
					+ "SELECT ?o1 ?s2 ?average "
					+ "FROM STREAM <sensorTM2> [RANGE 5s TUMBLING] " //STEP 5s
					+ "FROM STREAM <sensorTM1> [RANGE 5s TUMBLING] "
					+ "WHERE { "
					+ " :sensorTM1 :madeObservation ?o1 ." // ?s instead of :sensorTM1 for both cases
					+ " ?o1 :hasSimpleResult ?p1 ."
					+ " ?o1 :hasTime ?r1 . "
					//+ " ?s2 :madeObservation ?o2 ."
					+ "{ SELECT ?s2 ( avg(?p2) AS ?average ) "
					+ "  WHERE { "
					+ "    ?s2 :madeObservation ?o2 ." //
					+ "    ?o2 :hasSimpleResult ?p2 ."
					+ "    ?o2 :hasTime ?r2 ."
					+ "  } "
					+ "  GROUP BY ?s2"
					+ "  HAVING ( avg(?p2) > 2 ) "
					+ "} "
					+ "FILTER ( ?s2 != :sensorTM1 ) . "
					//+ "FILTER (f:timestamp(:sensorTM1,:madeObservation,?o1) < f:timestamp(?s1,:madeObservation,?o2)"
					//+ " && ?p > 1 && ?p1 > 2 && ?s1 != :sensorTM1 ). "
					+ " } ";
					//+ "GROUP BY ?s1 "
					//+ "HAVING ( avg(?p1) > 1 ) ";
			
			/*
			String queryBody = "REGISTER QUERY reasoning AS "
					+ "PREFIX :<http://onto#> "
					+ "PREFIX f: <http://larkc.eu/csparql/sparql/jena/ext#> "
					//+ "CONSTRUCT { ?s :isIn ?p } "
					+ "SELECT ?o1 ?o2 "
					+ "FROM STREAM <sensorTM2> [RANGE 5s TUMBLING] "
					+ "FROM STREAM <sensorTM1> [RANGE 5s TUMBLING] "
					+ "WHERE { "
					+ "{ :sensorTM1 :madeObservation ?o1 ." // ?s instead of :sensorTM1 for both cases
					+ " ?o1 :hasSimpleResult ?p ."
					+ " ?o1 :hasTime ?r . "
					+ " ?s1 :madeObservation ?o2 ."
					+ " ?o2 :hasSimpleResult ?p1 ."
					+ " ?o2 :hasTime ?r1 ."
					+ "FILTER (f:timestamp(:sensorTM1,:madeObservation,?o1) < f:timestamp(?s1,:madeObservation,?o2)"
					+ " && ?p > 1 && ?p1 > 2 && ?s1 != :sensorTM1 ). }"
					+ "} ";
			*/
			
			SensorsStreamer1 streamSTM1 = new SensorsStreamer1("sensorTM1", "http://onto#", 1000L);
			SensorsStreamer streamSTM2 = new SensorsStreamer("sensorTM2", "http://onto#", 100L);

			//Register new streams in the engine
			engine.registerStream(streamSTM2);
			engine.registerStream(streamSTM1);

			Thread streamSTM2Thread = new Thread(streamSTM2);
			Thread streamSTM1Thread = new Thread(streamSTM1);

			//Register new query in the engine
			CsparqlQueryResultProxy c = engine.registerQuery(queryBody, false);			

			//Attach a result consumer to the query result proxy to print the results on the console
			c.addObserver(new ConsoleFormatter());

			//Start streaming data
			streamSTM2Thread.start();
			streamSTM1Thread.start();

			engine.updateReasoner(c.getSparqlQueryId(), CsparqlUtils.fileToString("examples_files/rdfs.rules"), ReasonerChainingType.FORWARD, CsparqlUtils.serializeRDFFile("examples_files/tbox.rdf"));

		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

}