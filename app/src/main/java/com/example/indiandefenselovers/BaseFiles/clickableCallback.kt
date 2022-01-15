package com.example.indiandefenselovers.BaseFiles

import com.example.indiandefenselovers.repository.model.Clickable

interface clickableCallback {
    fun onItemClick(item: Clickable?)
}