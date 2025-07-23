package com.slicentoapp.deleveryapp.presentation.shop.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.ModalBottomSheetProperties
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.slicentoapp.deleveryapp.data.Pizza


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    sheetState: SheetState,
    pizza: Pizza,
    onDismiss: () -> Unit,
    onClick: () -> Unit
) {

    ModalBottomSheet(sheetState = sheetState,
        containerColor = Color.White,
        contentColor = Color.Black,
        properties = ModalBottomSheetDefaults.properties(
            shouldDismissOnBackPress = false
        ),
        modifier = Modifier,
        onDismissRequest = { onDismiss() }) {
        PizzaCard(pizza = pizza)
        RadioButtonGroup()
        Spacer(modifier = Modifier.padding(8.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp).navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            OutlinedButton(
                onClick = { },
                modifier = Modifier.weight(1f),
                border = BorderStroke(
                    0.dp,
                    Color.Transparent
                ),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = MaterialTheme.colorScheme.primary,
                    containerColor = MaterialTheme.colorScheme.primary.copy(0.2f),
                )
            ) {
                Text(text = "Add to cart", fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Button(
                onClick = onClick,
                modifier = Modifier
                    .weight(1f)
            ) {
                Text(text = "Place Order")
            }
        }

    }


}

@Composable
fun PizzaCard(pizza: Pizza) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = pizza.image),
            contentDescription = pizza.name,
            modifier = Modifier.size(100.dp)
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.Start
        ) {

            Text(
                text = pizza.name,
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,

                )

            Spacer(modifier = Modifier.padding(8.dp))
            SelectQuantity()

            Spacer(modifier = Modifier.padding(8.dp))









        }

        HorizontalDivider(
            color = MaterialTheme.colorScheme.onBackground,
            thickness = 1.dp
        )




    }

}

@Composable
fun SelectQuantity() {
    var quantity by remember { mutableIntStateOf(1) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {


        Text(
            text = "-",
            color = Color.White,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .clip(CircleShape)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
                .clickable {
                    if (quantity > 1)
                        quantity--
                },
            maxLines = 1,
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )


        Box(

            modifier = Modifier
                .clip(RoundedCornerShape(18.dp))
                .width(80.dp)
                .height(30.dp)
                .border(
                    width = 1.dp,
                    color = MaterialTheme.colorScheme.onBackground,
                    shape = RoundedCornerShape(18.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = quantity.toString(),
                style = MaterialTheme.typography.bodyLarge,
                color = Color.Black,
                textAlign = TextAlign.Center,
                fontSize = 18.sp
            )
        }

        Text(
            text = "+",
            color = Color.White,
            modifier = Modifier
                .width(30.dp)
                .height(30.dp)
                .clip(CircleShape)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                )
                .clickable {
                    quantity++
                },
            maxLines = 1,
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )


    }
}


@Composable
fun RadioButtonGroup() {
    val options = listOf("6 inches @$10", "7 inches @$12", "8 inches @$14", "10 inches @$16")
    var selectedOption by remember { mutableStateOf(options[0]) }

    Column(Modifier.padding(horizontal = 16.dp)) {
        Text("Select an option:", fontSize = 12.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(4.dp))

        options.forEach { option ->
            Row(
                Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .selectable(
                        selected = (option == selectedOption),
                        onClick = { selectedOption = option }
                    )
                ,
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (option == selectedOption),
                    onClick = { selectedOption = option }
                )
                Text(
                    text = option,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}