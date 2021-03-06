package srOntoInd4;

import eu.larkc.csparql.common.RDFTable;
import eu.larkc.csparql.common.RDFTuple;
import eu.larkc.csparql.common.streams.format.GenericObservable;
import eu.larkc.csparql.core.ResultFormatter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import com.clarkparsia.owlapi.explanation.BlackBoxExplanation;
import com.clarkparsia.owlapi.explanation.HSTExplanationGenerator;
import com.clarkparsia.owlapi.explanation.SatisfiabilityConverter;
import org.eclipse.rdf4j.model.URI;
import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.HermiT.ReasonerFactory;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.SystemOutDocumentTarget;
import org.semanticweb.owlapi.model.AddAxiom;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLIndividualAxiom;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLObjectPropertyAssertionAxiom;
import org.semanticweb.owlapi.model.OWLObjectPropertyExpression;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyChangeException;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.OWLSubClassOfAxiom;
import org.semanticweb.owlapi.reasoner.InferenceType;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.util.InferredAxiomGenerator;
import org.semanticweb.owlapi.util.InferredClassAssertionAxiomGenerator;
import org.semanticweb.owlapi.util.InferredClassAxiomGenerator;
import org.semanticweb.owlapi.util.InferredDataPropertyCharacteristicAxiomGenerator;
import org.semanticweb.owlapi.util.InferredDisjointClassesAxiomGenerator;
import org.semanticweb.owlapi.util.InferredEquivalentClassAxiomGenerator;
import org.semanticweb.owlapi.util.InferredEquivalentDataPropertiesAxiomGenerator;
import org.semanticweb.owlapi.util.InferredEquivalentObjectPropertyAxiomGenerator;
import org.semanticweb.owlapi.util.InferredIndividualAxiomGenerator;
import org.semanticweb.owlapi.util.InferredInverseObjectPropertiesAxiomGenerator;
import org.semanticweb.owlapi.util.InferredObjectPropertyAxiomGenerator;
import org.semanticweb.owlapi.util.InferredObjectPropertyCharacteristicAxiomGenerator;
import org.semanticweb.owlapi.util.InferredOntologyGenerator;
import org.semanticweb.owlapi.util.InferredSubClassAxiomGenerator;
import org.semanticweb.owlapi.util.InferredSubDataPropertyAxiomGenerator;
import org.semanticweb.owlapi.util.InferredSubObjectPropertyAxiomGenerator;
import org.swrlapi.core.SWRLAPIRule;
import org.swrlapi.core.SWRLRuleEngine;
import org.swrlapi.exceptions.SWRLBuiltInException;
import org.swrlapi.factory.SWRLAPIFactory;
import org.swrlapi.parser.SWRLParseException;

public class ConsoleFormatter extends ResultFormatter {

  private String situationName;
  private String baseUri;
  private OWLOntology ontology;
  private OWLDataFactory factory;
  // private OWLOntologyManager manager;

  public ConsoleFormatter(String situationName, String baseUri, OWLOntology ontology, OWLDataFactory factory,
      OWLOntologyManager manager) {
    this.situationName = situationName;
    this.baseUri = baseUri;
    this.ontology = ontology;
    this.factory = factory;
    // this.manager = manager;
  }

  @Override
  public void update(Observable o, Object arg) {

    RDFTable rdfTable = (RDFTable) arg;
    System.out.println();

    if (rdfTable.size() == 0)
      System.out.println(situationName + " NO DETECTED.");
    else {
      // String pre_TIME = "http://www.w3.org/2006/time#";
      String pre_SOSAOnt = "http://www.w3.org/ns/sosa/";

      System.out.println(situationName + " DETECTED. " + rdfTable.size() + " result at SystemTime: " + System.currentTimeMillis());
      int sizeTuple = rdfTable.getNames().size();
      rdfTable.stream().forEach((t) -> {
        System.out.println(t.get(0) + " and " + t.get(1) + " are involved in situation " + situationName);

        OWLClass Situation = factory.getOWLClass(IRI.create(baseUri + "Situation-" + situationName));
        OWLIndividual sit = factory
            .getOWLNamedIndividual(IRI.create(baseUri, situationName + "-" + System.currentTimeMillis()));
        OWLClassAssertionAxiom sitType = factory.getOWLClassAssertionAxiom(Situation, sit);
        ontology.add(sitType);
        // AddAxiom addAxiomsitType = new AddAxiom(ontology, sitType);
        // manager.applyChange(addAxiomsitType);
        
        OWLClass Observation = factory.getOWLClass(IRI.create(pre_SOSAOnt + "Observation"));
        OWLObjectProperty hasObservation = factory.getOWLObjectProperty(IRI.create(baseUri + "hasObservation"));
        for (int i = 2; i < sizeTuple; i++) {
          OWLIndividual Obs = factory.getOWLNamedIndividual(IRI.create(t.get(i)));  
          OWLClassAssertionAxiom ObsType = factory.getOWLClassAssertionAxiom(Observation, Obs);
          ontology.add(ObsType);
          OWLObjectPropertyAssertionAxiom hasObsSitObs = factory.getOWLObjectPropertyAssertionAxiom(hasObservation, sit, Obs);
          ontology.add(hasObsSitObs);
        }
        

        OWLClass Machine = factory.getOWLClass(IRI.create(baseUri + "Machine"));
        OWLIndividual M3 = factory.getOWLNamedIndividual(IRI.create(t.get(0)));
        OWLClassAssertionAxiom machineM3 = factory.getOWLClassAssertionAxiom(Machine, M3);
        ontology.add(machineM3);
        // AddAxiom addAxiommachineM3 = new AddAxiom(ontology, machineM3);
        // manager.applyChange(addAxiommachineM3);

        OWLClass Line = factory.getOWLClass(IRI.create(baseUri + "Line"));
        OWLIndividual PL1 = factory.getOWLNamedIndividual(IRI.create(t.get(1)));
        OWLClassAssertionAxiom pordLinePL1 = factory.getOWLClassAssertionAxiom(Line, PL1);
        ontology.add(pordLinePL1);
        // AddAxiom addAxiompordLinePL1 = new AddAxiom(ontology, pordLinePL1);
        // manager.applyChange(addAxiompordLinePL1);

        OWLObjectProperty concernBy = factory.getOWLObjectProperty(IRI.create(baseUri + "concernBy"));
        OWLObjectPropertyAssertionAxiom concernByAssertM3 = factory.getOWLObjectPropertyAssertionAxiom(concernBy, M3,
            sit);
        ontology.add(concernByAssertM3);
        // AddAxiom addAxiomconcernByAssertM3 = new
        // AddAxiom(ontology,concernByAssertM3);
        // manager.applyChange(addAxiomconcernByAssertM3);

        OWLObjectPropertyAssertionAxiom concernByAssertPL1 = factory.getOWLObjectPropertyAssertionAxiom(concernBy, PL1,
            sit);
        ontology.add(concernByAssertPL1);
        // AddAxiom addAxiomconcernByAssertPL1 = new AddAxiom(ontology,
        // concernByAssertPL1);
        // manager.applyChange(addAxiomconcernByAssertPL1);

        try {
          ontology.saveOntology();
        } catch (OWLOntologyStorageException e1) {
          e1.printStackTrace();
        }
      });

      /*
       * Classical Reasoner sub-module of the Cause Determination module. 
       */
      OWLReasonerFactory reasonerFactory_CauseDet = new ReasonerFactory();
      OWLReasoner ruleEngine_CauseDet = reasonerFactory_CauseDet.createReasoner(ontology);
      boolean consistencyCheck = ruleEngine_CauseDet.isConsistent();

      /*
       * try { ruleEngine_CauseDet.createSWRLRule("CauseDetermination",
       * "http://semanticweb.org/STEaMINg/ContextOntology-COInd4#Situation-S6(?sit)" +
       * "->  http://semanticweb.org/STEaMINg/ContextOntology-COInd4#hasCause(?sit, http://semanticweb.org/STEaMINg/ContextOntology-COInd4#PollutedFilters) "
       * ); } catch (Exception e) { e.printStackTrace(); }
       * ruleEngine_CauseDet.infer();
       */

      if (consistencyCheck) {
        // ruleEngine_CauseDet.precomputeInferences(InferenceType.CLASS_HIERARCHY,
        // InferenceType.CLASS_ASSERTIONS, InferenceType.OBJECT_PROPERTY_HIERARCHY,
        // InferenceType.DATA_PROPERTY_HIERARCHY,
        // InferenceType.OBJECT_PROPERTY_ASSERTIONS);
        ruleEngine_CauseDet.precomputeInferences(InferenceType.CLASS_ASSERTIONS,InferenceType.OBJECT_PROPERTY_ASSERTIONS);

        List<InferredAxiomGenerator<? extends OWLAxiom>> generators = new ArrayList<>();
        generators.add(new InferredSubClassAxiomGenerator());
        generators.add(new InferredClassAssertionAxiomGenerator());
        // generators.add(new InferredDataPropertyCharacteristicAxiomGenerator());
        generators.add(new InferredEquivalentClassAxiomGenerator());
        // generators.add(new InferredEquivalentDataPropertiesAxiomGenerator());
        // generators.add(new InferredEquivalentObjectPropertyAxiomGenerator());
        /// generators.add(new InferredInverseObjectPropertiesAxiomGenerator());
        // generators.add(new InferredObjectPropertyCharacteristicAxiomGenerator());
        generators.add(new org.semanticweb.owlapi.util.InferredPropertyAssertionGenerator());
        // generators.add(new InferredSubClassAxiomGenerator());
        // generators.add(new InferredSubDataPropertyAxiomGenerator());
        // generators.add(new InferredSubObjectPropertyAxiomGenerator());
        // List<InferredIndividualAxiomGenerator<? extends OWLIndividualAxiom>>
        // individualAxioms = new ArrayList<>();
        // generators.addAll(individualAxioms);
        // generators.add(new InferredDisjointClassesAxiomGenerator());

        InferredOntologyGenerator iog = new InferredOntologyGenerator(ruleEngine_CauseDet, generators);
        // InferredOntologyGenerator iog = new InferredOntologyGenerator(ruleEngine_CauseDet);

        try {
          iog.fillOntology(factory, ontology);
        } catch (OWLOntologyChangeException e1) {
          e1.printStackTrace();
        }
        try {
          ontology.saveOntology();
        } catch (OWLOntologyStorageException e1) {
          e1.printStackTrace();
        }
        /*
         * OWLOntology inferredAxiomsOntology = null; try { inferredAxiomsOntology =
         * manager.createOntology(); } catch (OWLOntologyCreationException e) { // TODO
         * Auto-generated catch block e.printStackTrace(); }
         * 
         * File inferredOntologyFile = new File( //
         * "/home/franco/Repositories/SR-OntoInd4/SROntoInd4/ContextOntology-COInd4.owl"
         * ); "inferredAxioms"+System.currentTimeMillis()+".txt"); OutputStream
         * outputStream = null; try { outputStream = new
         * FileOutputStream(inferredOntologyFile); } catch (FileNotFoundException e1) {
         * // TODO Auto-generated catch block e1.printStackTrace(); }
         * 
         * iog.fillOntology(factory, inferredAxiomsOntology);
         * 
         * try { manager.saveOntology(inferredAxiomsOntology, outputStream); } catch
         * (OWLOntologyStorageException e) { // TODO Auto-generated catch block
         * e.printStackTrace(); }
         */
      } // End if consistencyCheck
      else {
        System.out.println("Inconsistent COInd4 Ontology.");
      }

      try {
        ontology.saveOntology();
      } catch (OWLOntologyStorageException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      System.out.println("CAUSE DETERMINATION DONE.");
      System.out.println();
    }
    /*
     * for (final RDFTuple t : res) { System.out.println(t.toString()); }
     * System.out.println();
     */
  }

}