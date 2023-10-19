package program;

import instruction.Block;

import java.util.*;

public class ProgramProcedures {
    private Map<String,List<Procedure>> procedures = new TreeMap<>();

    public void newProcedure(String name, List<Character> params, Block block) {
        Procedure procedure = new Procedure(name, params, block);
        if (procedures.containsKey(name)) {
            procedures.get(name).add(procedure);
        }
        else {
            List<Procedure> procedureList = new LinkedList<>();
            procedureList.add(procedure);
            procedures.put(name, procedureList);
        }
    }
    public void popProcedure(String name) {
        int size = procedures.get(name).size();
        procedures.get(name).remove(size - 1);
        if (procedures.get(name).isEmpty()) {
            procedures.remove(name);
        }
    }
    public Procedure getProcedure(String name) {
        if (procedures.containsKey(name)) {
            int size = procedures.get(name).size();
            return procedures.get(name).get(size - 1);
        }
        else {
            System.out.println("Procedure "  + name + " do not exit!");
            System.exit(1);
            return null;
        }
    }
    public String writeProcedures() {
        String output = "";
        for (String key : procedures.keySet()) {
            int size = procedures.get(key).size();
            output += procedures.get(key).get(size - 1).writeProcedure();
        }
        return output;
    }
}