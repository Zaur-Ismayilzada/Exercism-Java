import java.util.List;
import java.util.ArrayList;

import java.util.List;
import java.util.ArrayList;

class ProteinTranslator {

    List<String> translate(String rnaSequence) {
        List<String> list = new ArrayList<String>();
		
		while (!rnaSequence.isEmpty()){
			String temp = rnaSequence.substring (0, 3);
			if (temp.equals("UAA") ||
			    temp.equals("UAG") ||
				temp.equals("UGA"))
				break;
			else if (temp.equals("AUG"))
				list.add ("Methionine");
			else if (temp.equals("UUU") ||
			         temp.equals("UUC"))
				list.add ("Phenylalanine");
			else if (temp.equals("UUA") ||
			         temp.equals("UUG"))
				list.add ("Leucine");
			else if (temp.equals("UCU") ||
			         temp.equals("UCC") ||
					 temp.equals("UCA") ||
					 temp.equals("UCG"))
				list.add ("Serine");
			else if (temp.equals("UAU") ||
					 temp.equals("UAC"))
				list.add ("Tyrosine");
			else if (temp.equals("UGU") ||
			         temp.equals("UGC"))
				list.add ("Cysteine");
			else if (temp.equals("UGG"))
				list.add ("Tryptophan");
			rnaSequence = rnaSequence.substring(3);
		}
		return list;
    }
}

