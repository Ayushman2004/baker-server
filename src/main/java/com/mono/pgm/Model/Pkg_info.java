package com.mono.pgm.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document(collection = "pkg_info")
public class Pkg_info
{
    @Id
    private String name;

    private String version;
    private String description;
    private int headerFileCount;
    private int srcFileCount;
    private int binFileCount;
    private int debugLibFileCount;
    private int debugBinFileCount;
    private List<String> headerFiles;
    private List<String> srcFiles;
    private List<String> binFiles;
    private List<String> debugLibFiles;
    private List<String> debugBinFiles;
    private String message;

    /*
{
  "name": "my-package",
  "version": "1.0.0",
  "description": "the desc",
  "headerFiles": [
    "include/header1.h",
    "include/header2.h"
  ],
  "srcFiles": [
    "src/main.cpp",
    "src/utils.cpp",
    "src/logger.cpp"
  ],
  "binFiles": [
    "bin/my-package"
  ]
}
     */

    public Pkg_info(String name, String description, String version, List<String> headerFiles, List<String> binFiles, List<String> srcFiles, List<String> debugLibFiles, List<String> debugBinFiles)
    {

        this.name = name;
        this.version = version;
        this.description = description;
        this.headerFileCount = headerFiles.size();
        this.srcFileCount = srcFiles.size();
        this.binFileCount = binFiles.size();
        this.debugBinFileCount = debugBinFiles.size();
        this.debugLibFileCount = debugLibFiles.size();
        this.headerFiles = headerFiles;
        this.binFiles = binFiles;
        this.srcFiles = srcFiles;
        this.debugBinFiles = debugBinFiles;
        this.debugLibFiles = debugLibFiles;
        this.message = "present";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHeaderFileCount() {
        return headerFileCount;
    }

    public void setHeaderFileCount(int headerFileCount) {
        this.headerFileCount = headerFileCount;
    }

    public int getSrcFileCount() {
        return srcFileCount;
    }

    public void setSrcFileCount(int srcFileCount) {
        this.srcFileCount = srcFileCount;
    }

    public int getBinFileCount() {
        return binFileCount;
    }

    public void setBinFileCount(int binFileCount) {
        this.binFileCount = binFileCount;
    }

    public List<String> getHeaderFiles() {
        return headerFiles;
    }

    public void setHeaderFiles(List<String> headerFiles) {
        this.headerFiles = headerFiles;
    }

    public List<String> getSrcFiles() {
        return srcFiles;
    }

    public void setSrcFiles(List<String> srcFiles) {
        this.srcFiles = srcFiles;
    }

    public List<String> getBinFiles() {
        return binFiles;
    }

    public void setBinFiles(List<String> binFiles) {
        this.binFiles = binFiles;
    }

    public int getDebugLibFileCount() {
        return debugLibFileCount;
    }

    public void setDebugLibFileCount(int debugLibFileCount) {
        this.debugLibFileCount = debugLibFileCount;
    }

    public int getDebugBinFileCount() {
        return debugBinFileCount;
    }

    public void setDebugBinFileCount(int debugBinFileCount) {
        this.debugBinFileCount = debugBinFileCount;
    }

    public List<String> getDebugLibFiles() {
        return debugLibFiles;
    }

    public void setDebugLibFiles(List<String> debugLibFiles) {
        this.debugLibFiles = debugLibFiles;
    }

    public List<String> getDebugBinFiles() {
        return debugBinFiles;
    }

    public void setDebugBinFiles(List<String> debugBinFiles) {
        this.debugBinFiles = debugBinFiles;
    }

    public String getMessage() {
        return message;
    }

}
