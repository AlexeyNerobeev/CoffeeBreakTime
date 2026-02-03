package com.example.coffeebreaktime.data.Connect

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object Connect {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://fftixgiacmrjokcjqvoe.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZmdGl4Z2lhY21yam9rY2pxdm9lIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Njk5OTA4NjIsImV4cCI6MjA4NTU2Njg2Mn0.P3BkQWmkSFeFG4LXf-f4DL6wMMTQmfaoW2i5PIdwZ50"
    ){
        install(Auth)
        install(Postgrest)
    }
}