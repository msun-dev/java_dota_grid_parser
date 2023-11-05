package dev.msun.starter;

import java.io.IOException;

// import dev.msun.parser.Parser;

public class Starter {

    public static void start() throws IOException {
        String DOTA_RUN_COMMAND = "powershell.exe steam://run/570";
        Process powerShellProcess = Runtime.getRuntime().exec(DOTA_RUN_COMMAND);
        powerShellProcess.getOutputStream().close();
    }
}