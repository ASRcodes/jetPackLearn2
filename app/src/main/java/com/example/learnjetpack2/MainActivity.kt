package com.example.learnjetpack2

import android.os.Bundle
import android.view.MotionEvent
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.BoxWithConstraintsScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.layout.boundsInWindow
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.example.learnjetpack2.ui.theme.LearnJetPack2Theme
import kotlin.math.PI
import kotlin.math.atan2
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//                                 Simple animation in compose
//           var sizeState by remember { mutableStateOf(200.dp) }
//           val size by animateDpAsState(targetValue = sizeState,
//               tween(
//                   durationMillis = 3000,
//                   delayMillis = 300,
//                   easing = LinearOutSlowInEasing
//               )
//               spring(
//                   Spring.DampingRatioHighBouncy
//               )
//               keyframes {
//                   durationMillis = 5000
//                   sizeState at 0 with LinearEasing
//                   sizeState*1.5f at 1000 with FastOutLinearInEasing
//                   sizeState * 2f at 5000
//               }
//               tween(
//                   durationMillis = 1000
//               )
//               )
//            val infiniteTransition = rememberInfiniteTransition()
//            val color by infiniteTransition.animateColor(
//                initialValue = Color.Red,
//                targetValue = Color.Green,
//                animationSpec = infiniteRepeatable(
//                    tween(durationMillis = 2000),
//                    repeatMode = RepeatMode.Reverse
//                )
//            )
//            Box (
//                modifier = Modifier
//                    .size(size)
//                    .background(color),
//                contentAlignment = Alignment.Center
//            ){
//                Button(onClick = {
//                    sizeState+=50.dp
//                }) {
//                    Text("Increase size")
//                }
//            }
             
//                                  normal list using column

//            val scrollState = rememberScrollState()
//            Column (
//                modifier = Modifier
//                    .verticalScroll(scrollState)
//            ){
//                for (i in 1..50) {
//                    Text(
//                        text = "Item $i",
//                        fontSize = 24.sp,
//                        fontWeight = FontWeight.Bold,
//                        textAlign = TextAlign.Left,
//                        modifier = Modifier.fillMaxWidth()
//                            .padding(vertical = 24.dp)
//                    )
//                }
//            }

//                                  lazy column like recyclerView
            LazyColumn (modifier = Modifier
                .padding(top = 30.dp)
            ){
                items(5000){
                    Text(
                        text = "You're looking at item no. = $it",
                        textAlign = TextAlign.Left,
                        fontSize = 22.sp,
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 25.dp)
                    )
                }
            }

//                              Use of itemIndex
//            LazyColumn {
//                itemsIndexed(
//                    listOf("Anubhav","is","a","good","boy")
//                ){
//                    index, string ->
//                    Text(
//                        text = string,
//                        textAlign = TextAlign.Left,
//                        fontSize = 22.sp,
//                        textDecoration = TextDecoration.Underline,
//                        fontWeight = FontWeight.Bold,
//                        modifier = Modifier.padding(vertical = 25.dp)
//                    )
//                }
//            }

//                                           Constraint layout...
//            val constraints = ConstraintSet{
//                val greenBox = createRefFor("green")
//                val redBox = createRefFor("red")
//                val guideline = createGuidelineFromTop(0.5f)
//                constrain(greenBox){
//                    top.linkTo(guideline)
////                    top.linkTo(parent.top)
//                    start.linkTo(parent.start)
//                    width = Dimension.value(100.dp)
//                    height = Dimension.value(100.dp)
//                }
//                constrain(redBox){
//                    top.linkTo(parent.top)
//                    start.linkTo(greenBox.end)
//                    end.linkTo(parent.end)
////                    width = Dimension.fillToConstraints
//                    width = Dimension.value(100.dp)
//                    height = Dimension.value(100.dp)
//                }
//                createHorizontalChain(greenBox,redBox, chainStyle = ChainStyle.Spread)
//            }
//            ConstraintLayout (constraints, modifier = Modifier.fillMaxSize()){
//                Box(modifier = Modifier
//                    .background(Color.Green)
//                    .layoutId("green"))
//                Box(modifier = Modifier
//                    .background(Color.Red)
//                    .layoutId("red"))
//            }

//            Box(contentAlignment = Alignment.Center,
//                modifier = Modifier.fillMaxSize()
//                ){
//                CircularProgressBar(percentage = 0.85f, number = 100)
//            }

//                                        DRAGGABLE MUSIC KNOB IN jetpack
//            Box (
//                contentAlignment = Alignment.Center, modifier = Modifier
//                    .fillMaxSize()
//                    .background(Color(0xFF101010))
//            ){
//                Row(
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier
//                        .border(1.dp,Color.Green, RoundedCornerShape(10.dp))
//                        .padding(30.dp)
//                ) {
//                    var volume by remember {
//                        mutableStateOf(0f)
//                    }
//                    val barCount =20
//                    MusicKonbb (
//                        modifier = Modifier.size(100.dp)
//                    ){
//                        volume=it
//                    }
//                    Spacer(modifier = Modifier.size(20.dp))
//                    VolumeBar(
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .height(30.dp),
//                        activeBars = (barCount*volume).roundToInt(),
//                        barCount = barCount
//                    )
//                }
//            }

        }
    }
//    VOLUME BAR
//    @Composable
//    fun VolumeBar(
//        modifier: Modifier=Modifier,
//        activeBars:Int=0,
//        barCount:Int=10
//    ) {
//    BoxWithConstraints(
//        contentAlignment = Alignment.Center,
//        modifier = modifier
//    ) {
//        val barWidth = remember {
//            constraints.maxWidth/(2f*barCount)
//        }
//        androidx.compose.foundation.Canvas(modifier=modifier) {
//            for (i in 0 until barCount){
//                drawRoundRect(
//                    color = if (i in 0..activeBars) Color.Green else Color.DarkGray,
//                    topLeft = Offset(i*barWidth*2f+barWidth/2f,0f),
//                    size = Size(barWidth,constraints.maxHeight.toFloat()),
//                    cornerRadius = CornerRadius(0f)
//                )
//            }
//        }
//    }
//    }
//    DRAGGABLE MUSIC KNOB function IN jetpack
//    @OptIn(ExperimentalComposeUiApi::class)
//    @Composable
//    fun MusicKonbb(
//        modifier: Modifier = Modifier,
//        limitingAngle: Float = 25f,
//        onValueChange: (Float) -> Unit
//    ) {
//    var rotation by remember {
//        mutableStateOf(limitingAngle)
//    }
//    var touchX by remember {
//        mutableStateOf(0f)
//    }
//    var touchY by remember {
//        mutableStateOf(0f)
//    }
//    var centerX by remember {
//        mutableStateOf(0f)
//    }
//    var centerY by remember {
//        mutableStateOf(0f)
//    }
//    val minRotation = limitingAngle
//    val maxRotation = 360f-limitingAngle
//    Image(
//        painter = painterResource(id = R.drawable.music_knob),
//        contentDescription = "Music Knob",
//        modifier = modifier
//            .fillMaxSize()
//            .onGloballyPositioned {
//                val windowBound = it.boundsInWindow()
//                centerX = windowBound.size.width / 2f
//                centerY = windowBound.size.height / 2f
//            }
//            .pointerInteropFilter { event ->
//                touchX = event.x
//                touchY = event.y
//                val angle = -atan2(centerX-touchX,centerY-touchY)*(180f/ PI).toFloat()
//                when(event.action){
//                    MotionEvent.ACTION_DOWN,
//                        MotionEvent.ACTION_MOVE ->{
//                            if(angle !in -limitingAngle..limitingAngle){
//                                val fixedAngle = if(angle in -180f..-limitingAngle){
//                                    360f+angle
//                                }else{
//                                    angle
//                                }
//                                rotation = fixedAngle
//                                val constrainedRotation = fixedAngle.coerceIn(minRotation, maxRotation)
//                                val percent=(fixedAngle-limitingAngle)/(360f-2*limitingAngle)
//                                onValueChange(percent)
//                                true
//                            } else false
//                        }
//                    else -> false
//                }
//            }
//            .rotate(rotation)
//    )
//}

//    @Composable
//    fun CircularProgressBar(
//        percentage:Float,
//        number: Int,
//        fontSize:TextUnit=28.sp,
//        radius:Dp=50.dp,
//        color: Color=Color.Green,
//        strokeWidth:Dp=8.dp,
//        animDuration:Int=1000,
//        animDelay:Int=0
//    ) {
//        var animationPlayed by remember {
//            mutableStateOf(false)
//        }
//        var curPercentage = animateFloatAsState(
//            targetValue = if (animationPlayed) percentage else 0f,
//            animationSpec = tween(
//                durationMillis = animDuration,
//                delayMillis = animDelay
//            )
//        )
//        LaunchedEffect(key1 = true) {
//            animationPlayed=true
//        }
//        Box (
//            contentAlignment = Alignment.Center,
//            modifier = Modifier.size(radius*2f)
//        ){
//            androidx.compose.foundation.Canvas(modifier = Modifier.size(radius*2f)) {
//                drawArc(
//                    color = color,
//                    -90f,
//                    360*curPercentage.value,
//                    useCenter = false,
//                    style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
//                )
//            }
//            Text(
//                text = (curPercentage.value*number).toInt().toString(),
//                color = Color.Black,
//                fontSize = fontSize,
//                fontWeight = FontWeight.Bold
//            )
//        }
//    }
}
