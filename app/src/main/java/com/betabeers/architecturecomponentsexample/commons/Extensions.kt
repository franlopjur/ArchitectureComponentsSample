package com.betabeers.architecturecomponentsexample.commons

fun Any?.notNull(f: ()-> Unit){
    if (this != null){
        f()
    }
}