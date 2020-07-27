package com.example.consumingrest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExecOutput {
  private String output;
  private String statusCode;
  private String memory;
  private String cpuTime;

  public String getOutput() {
    return output;
  }

  public void setOutput(String output) {
    this.output = output;
  }

  @Override
  public String toString() {
    return "ExecOutput{" +
        "output='" + output + '\'' +
        ", statusCode='" + statusCode + '\'' +
        ", memory='" + memory + '\'' +
        ", cpuTime='" + cpuTime + '\'' +
        '}';
  }

  public String getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(String statusCode) {
    this.statusCode = statusCode;
  }

  public String getMemory() {
    return memory;
  }

  public void setMemory(String memory) {
    this.memory = memory;
  }

  public String getCpuTime() {
    return cpuTime;
  }

  public void setCpuTime(String cpuTime) {
    this.cpuTime = cpuTime;
  }
}
