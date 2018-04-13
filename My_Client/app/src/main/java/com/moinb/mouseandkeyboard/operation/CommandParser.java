package com.moinb.mouseandkeyboard.operation;

import com.google.gson.Gson;

public class CommandParser {

    public static String parseCommand(OperationData operation) {
        Gson gson = new Gson();
        return gson.toJson(operation, OperationData.class);
    }
}
