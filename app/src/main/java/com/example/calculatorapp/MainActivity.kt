package com.example.calculatorapp

import android.graphics.drawable.Icon
import android.os.Bundle
import android.view.RoundedCorner
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatorapp.ui.theme.CalculatorAppTheme
import com.example.calculatorapp.ui.theme.calculate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Calculator()
                }
            }
        }
    }
}
@Composable
fun Calculator(){
    var input by remember { mutableStateOf("") }
    var result by remember {mutableStateOf("")}

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom

    ){

        Text(
            text = input,
            modifier = Modifier
                .fillMaxWidth()
                .padding(50.dp),
            textAlign = TextAlign.End,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = result,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            textAlign = TextAlign.End,
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold
        )


        Row (modifier = Modifier.fillMaxWidth()) {

            Spacer(modifier = Modifier.width(16.dp))
                Button(onClick = { input=""
                                 result=""}, modifier =Modifier.padding(8.dp)
                ) {
                    Text(text = "AC")
                }



            Button(onClick = {  if(input.length>=1) {
                input=input.substring(0,(input.length-1))}else{
                    input=""
            } },modifier =Modifier.padding(8.dp)
            ) {
                Text(text = "<-")

            }
            Button(onClick = { input+="*1" },modifier =Modifier.padding(8.dp)) {
                Text(text = "%")
            }
            Button(onClick = {input+="/" },modifier =Modifier.padding(8.dp)) {
                Text(text = "/")
            }
        }
        Row (modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { input+="7" }, modifier =Modifier.padding(8.dp)
            ) {
                Text(text = "7")
            }


            Button(onClick = { input+="8" },modifier =Modifier.padding(8.dp)) {
                Text(text = "8")
            }
            Button(onClick = { input+="9"},modifier =Modifier.padding(8.dp)) {
                Text(text = "9")
            }
            Button(onClick = { input+="*" },modifier =Modifier.padding(8.dp)) {
                Text(text = "*")
            }
        }
        Row (modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { input+="4" }, modifier =Modifier.padding(8.dp)
            ) {
                Text(text = "4")
            }


            Button(onClick = { input+="5" },modifier =Modifier.padding(8.dp)) {
                Text(text = "5")
            }
            Button(onClick = { input+="6" },modifier =Modifier.padding(8.dp)) {
                Text(text = "6")
            }
            Button(onClick = { input+="-" },modifier =Modifier.padding(8.dp)) {
                Text(text = "-")
            }
        }
        Row (modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { input+="1" }, modifier =Modifier.padding(8.dp)
            ) {
                Text(text = "1")
            }


            Button(onClick = { input+="2" },modifier =Modifier.padding(8.dp)) {
                Text(text = "2")
            }
            Button(onClick = { input+="3" },modifier =Modifier.padding(8.dp)) {
                Text(text = "3")
            }
            Button(onClick = { input+="+" },modifier =Modifier.padding(8.dp)) {
                Text(text = "+")
            }
        }
        Row (modifier = Modifier.fillMaxWidth()) {
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { input+="00" }, modifier =Modifier.padding(8.dp)
            ) {
                Text(text = "00")
            }


            Button(onClick = {  input+="0" },modifier =Modifier.padding(8.dp)) {
                Text(text = "0")
            }
            Button(onClick = {  input+="." },modifier =Modifier.padding(8.dp)) {
                Text(text = ".")
            }
            Button(onClick = {
                var ans= calculate(input)
                result="";
                result=""+ans
                input="";
//                input=""+ans;
                 },modifier =Modifier.padding(8.dp),
//                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Yellow)
            colors = ButtonDefaults.buttonColors())
                {
                Text(text = "=")
            }
        }
    }
}




@Preview(showBackground = false)
@Composable
fun GreetingPreview() {
    CalculatorAppTheme {
        Calculator()
    }
}