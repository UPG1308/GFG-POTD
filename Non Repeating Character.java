

//User function Template for Java

class Solution
{
    //Function to find the first non-repeating character in a string.
    static char nonrepeatingCharacter(String S)
    {
        //Your code here
        HashMap<Character, Integer> hm = new LinkedHashMap<>();
        for(int i = 0 ; i < S.length(); i++){
            char c = S.charAt(i);
            if(hm.containsKey(c)){
                hm.replace(c, hm.get(c) + 1);
            }
            else hm.put(c , 1);
            
        }
        for(Map.Entry<Character, Integer> entry: hm.entrySet()){
            if(entry.getValue() == 1)return entry.getKey();
        }
        return '$';
    }
}
