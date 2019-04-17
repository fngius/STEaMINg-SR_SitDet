package eu.larkc.csparql.sr4ld2014.streamer;

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

		String ontologyURI = "http://onto";
		String ns = ontologyURI + "#";
		String pre_SOSAOnt = "http://www.w3.org/ns/sosa/";
		String pre_TIME = "http://www.w3.org/2006/time#";

		OWLClass Sensor = factory.getOWLClass(IRI.create(pre_SOSAOnt + "Sensor"));
		OWLClass Observation = factory.getOWLClass(IRI.create(pre_SOSAOnt + "Observation"));
		OWLClass ObservableProperty = factory.getOWLClass(IRI.create(pre_SOSAOnt + "ObservableProperty"));
		OWLClass TemporalEntity = factory.getOWLClass(IRI.create(pre_TIME + "TemporalEntity"));

		OWLObjectProperty madeObservation = factory.getOWLObjectProperty(IRI.create(pre_SOSAOnt + "madeObservation"));
		OWLObjectProperty observedProperty = factory.getOWLObjectProperty(IRI.create(pre_SOSAOnt + "observedProperty"));
		OWLDataProperty hasSimpleResult = factory.getOWLDataProperty(IRI.create(pre_SOSAOnt + "hasSimpleResult"));
		OWLObjectProperty hasTime = factory.getOWLObjectProperty(IRI.create(ns,"hasTime"));
		OWLDataProperty inXSDDateTimeStamp = factory.getOWLDataProperty(IRI.create(pre_TIME + "inXSDDateTimeStamp"));


		while(true){
			try{
				result = random.nextInt(5);
				//ZonedDateTime zdt = ZonedDateTime.now();
				//java.util.Date date = java.util.Date.from( zdt.toInstant() );
				Timestamp date = new Timestamp(System.currentTimeMillis());
				//observationIndex = random.nextInt(Integer.MAX_VALUE);

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

				OWLIndividual sensor = factory.getOWLNamedIndividual(IRI.create(ns,"sensorTM1"));
				OWLClassAssertionAxiom sensorType = factory.getOWLClassAssertionAxiom(Sensor, sensor);
				ontology.add(sensorType);
				OWLIndividual obs = factory.getOWLNamedIndividual(IRI.create(ns,"obsTM1-" + observationIndex));
				OWLClassAssertionAxiom obsType = factory.getOWLClassAssertionAxiom(Observation, obs);
				ontology.add(obsType);
				OWLIndividual prop = factory.getOWLNamedIndividual(IRI.create(ns,"Py"));
				OWLClassAssertionAxiom propType = factory.getOWLClassAssertionAxiom(ObservableProperty, prop);
				ontology.add(propType);

				OWLObjectPropertyAssertionAxiom sensormadeobs = factory.getOWLObjectPropertyAssertionAxiom(madeObservation, sensor, obs);
				ontology.add(sensormadeobs);
				OWLObjectPropertyAssertionAxiom observedProp = factory.getOWLObjectPropertyAssertionAxiom(observedProperty, obs, prop);
				ontology.add(observedProp);
				OWLIndividual time = factory.getOWLNamedIndividual(IRI.create(pre_TIME,"t-obsTM1-" + timeIndex));        		
				OWLClassAssertionAxiom timeType = factory.getOWLClassAssertionAxiom(TemporalEntity, time);
				ontology.add(timeType);
				OWLObjectPropertyAssertionAxiom obshastime = factory.getOWLObjectPropertyAssertionAxiom(hasTime, obs, time);
				ontology.add(obshastime);
				OWLDataPropertyAssertionAxiom timehasdate = factory.getOWLDataPropertyAssertionAxiom(inXSDDateTimeStamp, time, date + "^^http://www.w3.org/2001/XMLSchema#dateTimeStamp");
				ontology.add(timehasdate);
				OWLDataPropertyAssertionAxiom obshassimpleresult = factory.getOWLDataPropertyAssertionAxiom(hasSimpleResult, obs, result + "^^http://www.w3.org/2001/XMLSchema#integer");
				ontology.add(obshassimpleresult);

				try {
					ontology.saveOntology();
					System.out.println("STREAM 111111111111111111111111111111111111111");
				} catch (OWLOntologyStorageException e1) {
					e1.printStackTrace();
				}

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