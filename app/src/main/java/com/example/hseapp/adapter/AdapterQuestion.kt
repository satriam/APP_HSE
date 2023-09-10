import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hseapp.R

class AdapterQuestion(private val questionsArray: Array<String>) :
    RecyclerView.Adapter<AdapterQuestion.ViewHolder>() {

    // Inisialisasi array untuk menyimpan jawaban
    private val answers = Array(questionsArray.size) { "" }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_question, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val question = questionsArray[position]
        holder.questionTextView.text = question

        // Mengatur listener untuk RadioGroup
        holder.answerRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            val radioButton = holder.itemView.findViewById<RadioButton>(checkedId)
            val answer = radioButton.text.toString()
            answers[position] = answer
        }
    }

    override fun getItemCount(): Int {
        return questionsArray.size
    }

    // Mengambil jawaban untuk suatu indeks
    fun getAnswerForIndex(index: Int): String {
        return answers[index]
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val questionTextView: TextView = itemView.findViewById(R.id.question_text)
        val answerRadioGroup: RadioGroup = itemView.findViewById(R.id.radio_group)
    }
}
