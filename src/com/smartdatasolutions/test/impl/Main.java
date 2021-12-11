package com.smartdatasolutions.test.impl;

import com.smartdatasolutions.test.Member;
import com.smartdatasolutions.test.MemberExporter;
import com.smartdatasolutions.test.MemberFileConverter;
import com.smartdatasolutions.test.MemberImporter;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class Main extends MemberFileConverter {
    private Comparator<Member> c;


    @Override
    protected MemberExporter getMemberExporter() {
        // TODO
        return new MemberExporterImpl();
    }

    @Override
    protected MemberImporter getMemberImporter() {
        // TODO
        return new MemberImporterImpl();
    }

    @Override
    protected List<Member> getNonDuplicateMembers(List<Member> membersFromFile) {

        // TODO
        return membersFromFile.stream().distinct().collect(Collectors.toList());
    }

    @Override
    protected Map<String, List<Member>> splitMembersByState(List<Member> validMembers) {
        // TODO
        Map<String, List<Member>> tempHolderList = new HashMap<>();

        validMembers.stream().forEach(f -> {
            if (tempHolderList.containsKey(f.getState())) {
                tempHolderList.get(f.getState()).add(f);
                return;
            }
            List add = new ArrayList<>() ;
            add.add(f);
            tempHolderList.put(f.getState(), add);

        });
        return tempHolderList;

    }

    public static void main(String[] args) throws Exception {
        //TODO
        new Main().convert(new File(System.getProperty("user.dir") + "/Members.txt"), "./", "Output.csv");
//		main.getMemberImporter().importMembers();
    }

}
