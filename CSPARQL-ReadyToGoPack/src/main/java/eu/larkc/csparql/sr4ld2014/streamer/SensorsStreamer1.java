package eu.larkc.csparql.sr4ld2014.streamer;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import eu.larkc.csparql.cep.api.RdfQuadruple;
import eu.larkc.csparql.cep.api.RdfStream;

public class SensorsStreamer1 extends RdfStream implements Runnable  {
	
	private long sleepTime;
	private String baseUri;

	public SensorsStreamer1(String iri, String baseUri,long sleepTime) {
		super(iri);
		this.sleepTime = sleepTime;
		this.baseUri = baseUri;
	}

	public void run() {
		
		Random random = new Random();
		int result;
		int observationIndex = 0;
		int timeIndex = 0;
		
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


				observationIndex++;
				timeIndex++;
				TimeUnit.SECONDS.sleep(5);
				//Thread.sleep(sleepTime);

			} catch(Exception e){
				e.printStackTrace();
			}
		}

	}

}