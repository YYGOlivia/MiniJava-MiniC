package fr.n7.stl.minic;

import java.io.File;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    private static final String ERROR_DIR = "tests/error";
    private static final String NO_ERROR_DIR = "tests/no_error";
    private static boolean generateCode;

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equals("-v") || args[0].equals("--verify")) {
                System.out.println("Running in verification mode...");
                generateCode = false;
            } else {
                System.out.println("Running in compilation mode...");
                generateCode = true;
            }
        }
        try {
            int totalTests = 0;
            int passedTests = 0;

            // lancer les tests quidevraient réussir
            List<String> noErrorTests = findTestFiles(NO_ERROR_DIR);
            System.out.println("Running tests that should pass...");
            System.out.println("---------------------------------");
            for (String test : noErrorTests) {
                totalTests++;
                if (runTest(test, false)) {
                    passedTests++;
                    System.out.println("✓ " + test + " passed");
                } else {
                    System.out.println("✗ " + test + " failed (expected to pass)");
                }
            }

            // lancer les tests qui devraient échouer
            List<String> errorTests = findTestFiles(ERROR_DIR);
            System.out.println("\nRunning tests that should fail...");
            System.out.println("---------------------------------");
            for (String test : errorTests) {
                totalTests++;
                if (runTest(test, true)) {
                    passedTests++;
                    System.out.println("✓ " + test + " passed");
                } else {
                    System.out.println("✗ " + test + " failed (expected to fail)");
                }
            }

            // afficher le résultat final
            System.out.println("\nTest Summary:");
            System.out.println("Total tests: " + totalTests);
            System.out.println("Passed: " + passedTests);
            System.out.println("Failed: " + (totalTests - passedTests));

            if (passedTests < totalTests) {
                System.exit(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static List<String> findTestFiles(String directory) throws Exception {
        List<String> files = new ArrayList<>();
        File dir = new File(directory);

        if (dir.exists() && dir.isDirectory()) {
            Files.walk(Paths.get(directory))
                    .filter(Files::isRegularFile)
                    .filter(file -> file.getFileName().toString().endsWith(".block"))
                    .forEach(path -> files.add(path.toString()));
        }
        return files;
    }

    private static boolean runTest(String filename, boolean expectError) {
        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        try {

            System.setOut(new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                    // Do nothing
                }
            }));
            System.setErr(new PrintStream(new OutputStream() {
                @Override
                public void write(int b) {
                    // Do nothing
                }
            }));

            String[] args = generateCode
                    ? new String[] { filename }
                    : new String[] { "-v", filename };

            Driver.main(args);
            return !expectError;
        } catch (Exception e) {
            return expectError;
        } finally {
            System.setOut(originalOut);
            System.setErr(originalErr);
        }
    }
}