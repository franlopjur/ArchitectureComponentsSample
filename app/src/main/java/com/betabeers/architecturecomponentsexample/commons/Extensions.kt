package com.betabeers.architecturecomponentsexample.commons

fun Any?.notNull(functionToExecute: ()-> Unit){
    if (this != null){
        functionToExecute()
    }
}