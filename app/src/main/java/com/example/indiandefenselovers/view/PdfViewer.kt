package com.example.indiandefenselovers.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ProgressBar
import com.example.indiandefenselovers.databinding.FragmentPdfViewerBinding


class PdfViewer : Fragment() {

    private lateinit var binding: FragmentPdfViewerBinding
    private lateinit var progress: ProgressBar
    private lateinit var webView: WebView
    private lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentPdfViewerBinding.inflate(inflater, container, false)
        progress = binding.paperLoadingProgress
        url = arguments?.getString("url", "").toString()
//        webView = binding.webView
//        setupWebView()

        setupPdfViewer()

        return binding.root
    }

    private fun setupPdfViewer() {
        //pdfViewer.fromUri(Uri.parse(url))
    }

//    private fun setupWebView() {
//        url = arguments?.getString("url", "").toString()
//        webView.settings.apply {
//            javaScriptEnabled = true
//            builtInZoomControls = true
//            displayZoomControls = false
//        }
//        webView.webChromeClient = WebChromeClient()
//
//        webView.webViewClient = object : WebViewClient() {
//            override fun onPageFinished(view: WebView, url: String) {
//                webView.loadUrl("javascript:(function() { " +
//                        "document.querySelector('[role=\"toolbar\"]').remove();})()")
//                progress.visibility = View.GONE
//            }
//        }
//        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$url")
//
//    }

}