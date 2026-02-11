package com.example.coffeebreaktime.presentation.Designer

sealed class DesignerEvent {
    data object PanelChange: DesignerEvent()
}