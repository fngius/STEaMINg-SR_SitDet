package srOntoInd4.streamer;

import java.io.File;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.jena.dboe.sys.Sys;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import eu.larkc.csparql.cep.api.RdfQuadruple;
import eu.larkc.csparql.cep.api.RdfStream;

public class SensorsStreamer1 extends RdfStream implements Runnable  {

	private long sleepTime;
	private String baseUri;
	private OWLOntology ontology; 
	private OWLDataFactory factory;

	public SensorsStreamer1(String iri, String baseUri,long sleepTime, OWLOntology ontology,OWLDataFactory factory) {
		super(iri);
		this.sleepTime = sleepTime;
		this.baseUri = baseUri;
		this.ontology = ontology;
		this.factory = factory;
	}

	public void run() {

		Random random = new Random();
		int result;
		int observationIndex = 0;
		int timeIndex = 0;

		while(true){
			try{
				result = random.nextInt(5);
				Timestamp date = new Timestamp(System.currentTimeMillis());

				RdfQuadruple q = new RdfQuadruple(baseUri + "M1", baseUri + "hosts", baseUri + "sensorTM1", System.currentTimeMillis());
				System.out.println(q);
				this.put(q);
				q = new RdfQuadruple(baseUri + "sensorTM1", baseUri + "madeObservation", baseUri + "obsTM1-" + observationIndex, System.currentTimeMillis());
				System.out.println(q);
				this.put(q);
				q = new RdfQuadruple(baseUri + "obsTM1-" + observationIndex, baseUri + "observedProperty", baseUri + "Py", System.currentTimeMillis());
				System.out.println(q);
				this.put(q);
				q = new RdfQuadruple(baseUri + "obsTM1-" + observationIndex, baseUri + "hasSimpleResult", result + "^^http://www.w3.org/2001/XMLSchema#integer", System.currentTimeMillis());
				System.out.println(q);
				this.put(q);
				q = new RdfQuadruple(baseUri + "obsTM1-" + observationIndex, baseUri + "hasTime", baseUri + "t-obsTM1-" + timeIndex, System.currentTimeMillis());
				System.out.println(q);
				this.put(q);
				q = new RdfQuadruple(baseUri + "t-obsTM1-" + timeIndex, baseUri + "inXSDDateTime", date + "^^http://www.w3.org/2001/XMLSchema#dateTimeStamp", System.currentTimeMillis());
				System.out.println(q);
				this.put(q);

				System.out.println("STREAM 111111111111111111111111111111111111111");

				TimeUnit.SECONDS.sleep(10);
				//Thread.sleep(sleepTime);
				observationIndex++;
				timeIndex++;
			} catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}