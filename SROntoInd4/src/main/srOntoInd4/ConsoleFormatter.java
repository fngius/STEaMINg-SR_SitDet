package srOntoInd4;

import eu.larkc.csparql.common.RDFTable;
import eu.larkc.csparql.common.RDFTuple;
import eu.larkc.csparql.common.streams.format.GenericObservable;
import eu.larkc.csparql.core.ResultFormatter;
import java.util.Observable;

public class ConsoleFormatter extends ResultFormatter {
    @Override
    public void update(Observable o, Object arg) {
                RDFTable res = (RDFTable)arg;
                System.out.println();
		System.out.println("+++++++"+ res.size() + " result at SystemTime=["+System.currentTimeMillis()+"]--------");
		for (final RDFTuple t : res) {
			System.out.println(t.toString());
		}
		System.out.println(); 
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