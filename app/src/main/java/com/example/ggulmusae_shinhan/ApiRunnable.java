package com.example.ggulmusae_shinhan;

public interface ApiRunnable extends Runnable {
    public void setDbParams(String sheetName, String requestType);
}
