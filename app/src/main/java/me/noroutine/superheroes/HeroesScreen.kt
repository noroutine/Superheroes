package me.noroutine.superheroes

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import me.noroutine.superheroes.model.Hero
import me.noroutine.superheroes.model.HeroesRepository
import me.noroutine.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroCard(hero: Hero) {
    Card {
        Row {
            Column {
                Text(
                    text = stringResource(id = hero.nameRes)
                )
                Text(
                    text = stringResource(id = hero.descriptionRes)
                )
            }
            Icon(
                painter = painterResource(id = hero.imageRes),
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun HeroCardPreview() {
    SuperheroesTheme {
        HeroCard(HeroesRepository.heroes[0])
    }
}