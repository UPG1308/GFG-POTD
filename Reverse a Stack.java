
class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        ArrayList<Integer> list = new ArrayList<>(s);
        s.clear();
        for(int i = list.size() - 1; i >= 0; i--){
            s.add(list.get(i));
        }
    }
}
