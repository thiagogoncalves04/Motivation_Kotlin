package com.example.dell.motivations.mock

import android.provider.SyncStateContract
import com.example.dell.motivations.util.Constants
import java.util.*

class Phrase(val description: String, val category: Int)
fun Int.random() : Int{
   return Random().nextInt(this)
}

class Mock {

    private val ALL = Constants.PHRASE_FILTER.ALL
    private val SUN = Constants.PHRASE_FILTER.SUN
    private val HAPPY = Constants.PHRASE_FILTER.HAPPY

    private val mListPhrases: List<Phrase> = listOf(
            Phrase("Não sabendo que era impossível, foi lá e fez.", HAPPY),
            Phrase("Você não é derrotado quando perde, você é derrotado quando dsiste", HAPPY),
            Phrase("Quando está mais escuro, vemos mais estrelas!", HAPPY),
            Phrase("A melhor maneira de prever o futuro é inventá-lo", SUN),
            Phrase("Fracasso é o condimento que dá sabor ao sucesso.", SUN),
            Phrase("Se vovê acredita, faz toda a diferença!", SUN)
    )

    fun getPhrase(value: Int): String{
       val filtered = mListPhrases.filter { it -> it.category == value || value == ALL}
        val rand = (filtered.size).random()
         return filtered[rand].description
    }

}