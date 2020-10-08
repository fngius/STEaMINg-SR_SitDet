package srOntoInd4;

import eu.larkc.csparql.common.RDFTable;
import eu.larkc.csparql.common.RDFTuple;
import eu.larkc.csparql.common.streams.format.GenericObservable;
import eu.larkc.csparql.core.ResultFormatter;
import java.util.Observable;

import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

public class ConsoleFormatter extends ResultFormatter {
    
    private String situationName;
    private String baseUri;
    private OWLOntology ontology;
    private OWLDataFactory factory;

	  public ConsoleFormatter(String  situationName, String baseUri, OWLOntology ontology, OWLDataFactory factory) {
      this.situationName = situationName;
      this.baseUri = baseUri;
      this.ontology = ontology;
      this.factory = factory;
    }

    @Override
    public void update(Observable o, Object arg) {
      
      //private int sitIndex = 0;

      RDFTable rdfTable = (RDFTable)arg;
      System.out.println();
      
      if (rdfTable.size()==0)
        System.out.println("NO RESULT");
      else {
        String ontologyURI = "http://semanticweb.org/STEaMINg/ContextOntology-COInd4";
        String ns = ontologyURI + "#";
        String pre_SOSAOnt = "http://www.w3.org/ns/sosa/";
        String pre_TIME = "http://www.w3.org/2006/time#";

        System.out.println(situationName + " DETECTED. "+ rdfTable.size() + " result at SystemTime: "+System.currentTimeMillis());
        rdfTable.stream().forEach((t) -> {
          System.out.println(t.get(0) + " and " + t.get(1) + " are involved in situation " + situationName);
          
          OWLClass Situation = factory.getOWLClass(IRI.create(ns + "Situation"));
          OWLIndividual sit = factory.getOWLNamedIndividual(IRI.create(ns,situationName + "-" + System.currentTimeMillis()));
          OWLClassAssertionAxiom sitType = factory.getOWLClassAssertionAxiom(Situation, sit);
          ontology.add(sitType);
          OWLClass Machine = factory.getOWLClass(IRI.create(ns + "Machine"));
          OWLIndividual M3 = factory.getOWLNamedIndividual(IRI.create(t.get(0)));
          OWLClassAssertionAxiom machineM3 = factory.getOWLClassAssertionAxiom(Machine, M3);
          ontology.add(machineM3);
          OWLClass Line = factory.getOWLClass(IRI.create(ns + "Line"));
          OWLIndividual PL1 = factory.getOWLNamedIndividual(IRI.create(t.get(1)));
          OWLClassAssertionAxiom pordLinePL1 = factory.getOWLClassAssertionAxiom(Line, PL1);
          ontology.add(pordLinePL1);

          OWLObjectProperty concernBy = factory.getOWLObjectProperty(IRI.create(ns + "concernBy"));
          OWLObjectPropertyAssertionAxiom concernByAssertM3 = factory.getOWLObjectPropertyAssertionAxiom(concernBy, M3, sit);
          ontology.add(concernByAssertM3);
          OWLObjectPropertyAssertionAxiom concernByAssertPL1 = factory.getOWLObjectPropertyAssertionAxiom(concernBy, PL1, sit);
          ontology.add(concernByAssertPL1);
        
          try {
				  	ontology.saveOntology();
				  } catch (OWLOntologyStorageException e1) {
					  e1.printStackTrace();
          }
          
      });
      //sitIndex++;
    }
    //for (final RDFTuple t : res) {
		//	System.out.println(t.toString());
		//}
		//System.out.println(); 
    }
}
/*
public void update(Observable o, Object arg) {
  final RDFTable rdfTable = (RDFTable) arg;
  if (rdfTable.size()==0)
    System.out.println("NO RESULT!!!");
  else {
    rdfTable.stream().forEach((t) -> {System.out.println(t.get(0) + " ZZZ ");});
    i++;
  }
}
*/