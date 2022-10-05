package kr.ac.kumoh.s20180864.w0403counter

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kr.ac.kumoh.s20180864.w0403counter.ui.theme.W0403CounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyApp {
                Column{
                    Counter()
                    Counter()
                    Counter()
                }
                //Greeting(name="안녕하세요")
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    W0403CounterTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            content()
        }
    }
}

@Composable
fun Counter() {
    var cnt by remember { mutableStateOf(0)}
    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "$cnt", fontSize = 70.sp)

        Row(
            modifier = Modifier.padding(4.dp),
        ) {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    cnt++
                    Log.i("cnt", cnt.toString())
                }
            ) {
                Text(text = "증가", fontSize = 30.sp)
            }
            Spacer(modifier=Modifier.width(8.dp))
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    cnt = if(--cnt >= 0) cnt else 0
                    Log.i("cnt", cnt.toString())
                }
            ) {
                Text(text = "감소", fontSize = 30.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    W0403CounterTheme {
        // Greeting("Android")
        Counter()
    }
}