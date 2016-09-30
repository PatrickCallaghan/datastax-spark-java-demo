package com.datastax.demo;

import java.io.Serializable;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;

public class JavaDemo implements Serializable {
    private transient SparkConf conf;
  
    private JavaDemo(SparkConf conf) {
        this.conf = conf;
    }
  
    private void run() {
        JavaSparkContext sc = new JavaSparkContext(conf);
        generateData(sc);
        compute(sc);
        showResults(sc);
        sc.stop();
    }
  
    private void generateData(JavaSparkContext sc) {
    }
  
    private void compute(JavaSparkContext sc) {
    }
  
    private void showResults(JavaSparkContext sc) {
    }
  
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Syntax: com.datastax.spark.demo.JavaDemo <Spark Master URL> <Cassandra contact point>");
            System.exit(1);
        }
  
        SparkConf conf = new SparkConf();
        conf.setAppName("Java API demo");
        conf.setMaster(args[0]);
        conf.set("spark.cassandra.connection.host", args[1]);
  
        JavaDemo app = new JavaDemo(conf);
        app.run();
    } 
}