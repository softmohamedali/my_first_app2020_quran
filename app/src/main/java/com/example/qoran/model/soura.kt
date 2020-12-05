package com.example.qoran.model

data class soura(var id:Int,var name:String,var soura:ArrayList<aya>) {
    fun sup():String
    {
        var completesoura:String=""
        for (i in 0..(soura.size-1))
        {
            completesoura+=" ${soura[i].standard_full} <(${i+1})>"
        }
        return completesoura
    }
}