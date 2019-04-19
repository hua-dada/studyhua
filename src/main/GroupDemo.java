package com.huating.test;
import java.util.*;

public class GroupDemo {

    /**
     * 普通分组排序
     * @param list
     * @return
     */
    public static Map<String,List<Object>> sortByLetterAsc(List<Map<String,Object>> list) {
    if(list!=null){
        Map<String,Object> map = new HashMap<String,Object>();

        //按拼音首字母表排序
        Map<String, List<Object>> letterMap = new TreeMap<String,List<Object>>();
        if(!list.isEmpty()) {
            for (int i = 97; i <= 122; i++) {
                ArrayList list1 = new ArrayList<Object>();
                for (Object t : list) {
                    char firstZm1 = ((HashMap) t).get("abbr").toString().charAt(0);
                    byte asc=(byte)firstZm1;
                    //String name=PinYinUtils.getFullSpell(((HashMap) t).get("name").toString());
                    String firstZm = ((HashMap) t).get("abbr").toString().substring(0, 1);
                    if(asc==i) {
                        if (!letterMap.containsKey(firstZm) && firstZm.matches("[a-z]")) {
                            list1 = new ArrayList<Object>();
                            list1.add(t);
                            letterMap.put(firstZm, list1);
                            //letterMap.put(firstZm,new ArrayList<Object>());
                        } else {
                            list1.add(t);
                            letterMap.put(firstZm, list1);
                        }
                    }
                }
            }

        }
        ArrayList list2= new ArrayList<Object>();
        list2.add(letterMap);
        return letterMap;
    }else {

        return null;
    }

}

    /**
     *
     * @param list
     * @return list2:[{"title":"c"},[{"name":"陈杰","abbr":"cj"},{"name":"cc","abbr":"cc"}],
     * {"title":"h"},[{"name":"话杰","abbr":"huajie"}]]
     */
    public static List sortByLetterAsc1(List<Map<String,Object>> list) {
        if(list!=null){
            Map<String,Object> map = new HashMap<String,Object>();

            //按拼音首字母表排序
            ArrayList list2 = new ArrayList<Object>();
            if(!list.isEmpty()) {
                byte lastAscll = -1;
                List<Object> list1 = new ArrayList<Object>();
                for(int j = 0; j < list.size(); ++j){
                    Map<String, Object> t = list.get(j);
                    char firstZm =  t.get("abbr").toString().charAt(0);
                    byte a=(byte)firstZm;
                    if (a!=lastAscll) {
                        if(j == 0)
                        {
                            list1.add(t);
                        }
                        else
                        {
                            Map<String,Object> map2=new HashMap<>();
                            map2.put("title",((Map)list1.get(0)).get("abbr").toString().substring(0,1));
                            list2.add(map2);
                            list2.add(list1);
                            list1 = new ArrayList<Object>();
                            list1.add(t);
                        }
                    }
                    else {
                        list1.add(t);
                    }
                    lastAscll = a;
                    if(j == (list.size() - 1)) {
                        Map<String,Object> map3=new HashMap<>();
                        map3.put("title",((Map)list1.get(0)).get("abbr").toString().substring(0,1));
                        list2.add(map3);
                        list2.add(list1);
                    }
                }
            }
            return list2;
        }else {
            return null;
        }
    }


    public static void main(String[] args) throws Exception {
        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("abbr","cj");
        map.put("name","陈杰");
        Map<String,Object> map1=new HashMap<>();
        map1.put("abbr","cc");
        map1.put("name","cc");
        Map<String,Object> map2=new HashMap<>();
        map2.put("abbr","huajie");
        map2.put("name","话杰");

        list.add(map);
        list.add(map1);
        list.add(map2);
        System.out.println(sortByLetterAsc1(list));

    }
}

