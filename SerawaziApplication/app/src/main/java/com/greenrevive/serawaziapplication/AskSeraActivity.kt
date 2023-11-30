//package com.greenrevive.serawaziapplication
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import androidx.lifecycle.ViewModelProvider
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.greenrevive.serawaziapplication.databinding.ActivityAskSeraBinding
//import com.greenrevive.serawaziapplication.model.Message
//
//
//class AskSeraActivity : AppCompatActivity() {
//    private lateinit var _binding : ActivityAskSeraBinding
////    private lateinit var chatGptViewModel: ChatGptViewModel
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        _binding = ActivityAskSeraBinding.inflate(layoutInflater)
//        val binding = _binding.root
//        setContentView(binding)
//
////        chatGptViewModel = ViewModelProvider(this)[ChatGptViewModel::class.java]
//
//        val llm = LinearLayoutManager(this)
//        _binding.recyclerView.layoutManager = llm
//
//        chatGptViewModel.messageList.observe(this){messages ->
//            val adapter = MessageAdapter(messages)
//            _binding.recyclerView.adapter = adapter
//        }
//
//        _binding.sendBtn.setOnClickListener {
//            val question = _binding.messageEditText.text.toString()
//            chatGptViewModel.addToChat(question, Message.SENT_BY_ME,chatGptViewModel.getCurrentTimestamp())
//            _binding.messageEditText.setText("")
//            chatGptViewModel.callApi(question)
//        }
//
//
//    }
//}