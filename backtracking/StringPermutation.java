import java.util.*;
public class StringPermutation {

  /***
   * Naive version to find all permutations of the given string
   * @param str the string want to find all its permutations
   * @return a permutation list of the given string.
  **/
  public static List<String> findPerm(String str) {
    List<String> rs = new ArrayList<>();
    if ("".equals(str) || str.length() == 1) {
      rs.add(str);
      return rs;
    }
    for(int i = 0; i < str.length(); i++) {
       char curChar = str.charAt(i);
       String remStr = str.substring(0, i) + str.substring(i + 1);
       for(int j = 0; j < findPerm(remStr).size(); j++) {
         rs.add("" + curChar + findPerm(remStr).get(j));
       }
    }
    return rs;
  }
}
