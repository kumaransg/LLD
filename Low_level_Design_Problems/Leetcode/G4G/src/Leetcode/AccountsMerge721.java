package Leetcode;

import java.util.*;

public class AccountsMerge721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap();
        Map<String, ArrayList<String>> graph = new HashMap();
        for (List<String> account : accounts) {
            String name = "";
            for (String email : account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                graph.computeIfAbsent(email, x -> new ArrayList<String>()).add(account.get(1));
                graph.computeIfAbsent(account.get(1), x -> new ArrayList<String>()).add(email);
                emailToName.put(email, name);
            }
        }

        Set<String> seen = new HashSet();
        List<List<String>> ans = new ArrayList();
        for (String email : graph.keySet()) {
            if (!seen.contains(email)) {
                seen.add(email);
                Stack<String> stack = new Stack();
                stack.push(email);
                List<String> component = new ArrayList();
                while (!stack.empty()) {
                    String node = stack.pop();
                    component.add(node);
                    for (String nei : graph.get(node)) {
                        if (!seen.contains(nei)) {
                            seen.add(nei);
                            stack.push(nei);
                        }
                    }
                }
                Collections.sort(component);
                component.add(0, emailToName.get(email));
                ans.add(component);
            }
        }
        return ans;
    }

    public static void main(String args[]){
        List<List<String>>accounts = new ArrayList<>();
        List<String> l1 = new ArrayList<>(){
            {
                add("John");
                add("johnsmith@mail.com");
                add("john00@mail.com");
            }
        };
        List<String> l2 = new ArrayList<>(){{
            add("John");
            add("johnnybravo@mail.com");
        }};
        List<String> l3 = new ArrayList<>(){{
            add("John");
            add("johnsmith@mail.com");
            add("john_newyork@mail.com");
        }};

        List<String> l4 = new ArrayList<>(){
            {
                add("Mary");
                add("mary@mail.com");
            }
        };
        accounts.add(l1);
        accounts.add(l2);
        accounts.add(l3);
        accounts.add(l4);
        AccountsMerge721 am =  new AccountsMerge721();
        List<List<String>>accounts2 = am.accountsMerge(accounts);
        System.out.println(accounts2);

    }
}