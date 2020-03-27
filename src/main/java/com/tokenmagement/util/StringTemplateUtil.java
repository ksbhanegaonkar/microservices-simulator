package com.tokenmagement.util;

import com.tokenmagement.entity.RestEndpoint;
import com.tokenmagement.entity.UrlNode;

import java.util.*;

public class StringTemplateUtil {

    static Set<String> getAllPathParam(String url){
        Set<String> set = new HashSet<>();
        if(hasPathParam(url)){
            int startIndex = url.indexOf('{');
            int endIndex = 0;
            while( startIndex != -1){
                endIndex = url.indexOf('}',startIndex);
                set.add(url.substring(startIndex+1,endIndex));
                startIndex = url.indexOf('{',endIndex);
            }
        }
        return set;
    }



    public static boolean hasPathParam(String url){
        return url.indexOf('{') != -1;
    }

    public static void main(String[] args) {

            UrlNode baseNode = new UrlNode("simulator");

        List<RestEndpoint> list = Arrays.asList(new RestEndpoint("test","testjjj","/test12asas","/test12asassdfdsfsdf"),
                new RestEndpoint("tesdsfsdft","testjjj","/test12asassdfdsfsdf/abc/def","/test12asassdfdsfsdf"),
                new RestEndpoint("tesdsfsdft","testjjj","/test12asassdfdsfsdf/abc","/test12asassdfdsfsdf"),
                new RestEndpoint("tesdsfsdft","testjjj","/test12asassdfdsfsdf/ghi","/test12asassdfdsfsdf"));
        list.stream().forEach(e->{
            StringTokenizer st = new StringTokenizer(e.getUrl(),"/");
            Set<UrlNode> tmpSet = baseNode.getNextNodes();
            while (st.hasMoreTokens()){
                String token = st.nextToken();

                UrlNode tmpNode = new UrlNode(token);
                if(tmpSet.contains(tmpNode)){
                    tmpSet = getNextNodeSet(tmpSet,tmpNode);
                }else{
                    tmpSet.add(tmpNode);
                    tmpSet = tmpNode.getNextNodes();
                }

            }
        });

        System.out.println("hi");
    }

    private static Set<UrlNode> getNextNodeSet(Set<UrlNode> tmpSet, UrlNode tmpNode) {
        for(UrlNode n : tmpSet){
            if(n.equals(tmpNode)){
                return n.getNextNodes();
            }
        }
        return new HashSet<>();
    }

}
