package br.com.thiagoas.screenmatch.services;

public interface IConvertData {
    <T> T getData(String json, Class<T> classData);
}
