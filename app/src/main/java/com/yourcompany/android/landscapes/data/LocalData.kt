/*
 * Copyright (c) 2022 Razeware LLC
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * Notwithstanding the foregoing, you may not use, copy, modify, merge, publish,
 * distribute, sublicense, create a derivative work, and/or sell copies of the
 * Software in any work that is designed, intended, or marketed for pedagogical or
 * instructional purposes related to programming, coding, application development,
 * or information technology.  Permission for such use, copying, modification,
 * merger, publication, distribution, sublicensing, creation of derivative works,
 * or sale is expressly withheld.
 *
 * This project and source code may use libraries or frameworks that are
 * released under various Open-Source licenses. Use of those libraries and
 * frameworks are governed by their own individual licenses.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.yourcompany.android.landscapes.data

import com.yourcompany.android.landscapes.R

// Overviews
val NYC = CityOverview(
  name = "New York City",
  image = R.drawable.ic_nyc_overview,
  author = "Emiliano Bar",
  imagePage = "https://unsplash.com/photos/kheTI8pIywU"
)
val Berlin = CityOverview(
  name = "Berlin",
  image = R.drawable.ic_berlin_overview,
  author = "Florian Wehde",
  imagePage = "https://unsplash.com/photos/uFGi0_YciE0"
)
val SanFrancisco = CityOverview(
  name = "San Francisco",
  image = R.drawable.ic_sf_overview,
  author = "Natalie Chaney",
  imagePage = "https://unsplash.com/photos/KQVX1_pYpsA"
)
val Turin = CityOverview(
  name = "Turin",
  image = R.drawable.ic_turin_overview,
  author = "Fabio Fistarol",
  imagePage = "https://unsplash.com/photos/VjA_PSSsOHI"
)
val London = CityOverview(
  name = "London",
  image = R.drawable.ic_london_overview,
  author = "Veliko Karachiviev",
  imagePage = "https://unsplash.com/photos/hSvagWirWPA"
)
val Paris = CityOverview(
  name = "Paris",
  image = R.drawable.ic_paris_overview,
  author = "Anthony Tan",
  imagePage = "https://unsplash.com/photos/PULWFiQi2aU"
)

//Pictures
private val nycPic1 = Picture(
  image = R.drawable.ic_nyc_pic_1, author = "Triston Dunn",
  imagePage = "https://unsplash.com/photos/rfj_wOYQkus"
)
private val nycPic2 = Picture(
  image = R.drawable.ic_nyc_pic_2, author = "Trevor Hayes",
  imagePage = "https://unsplash.com/photos/IA8FR0RyJDE"
)
private val nycPic3 = Picture(
  image = R.drawable.ic_nyc_pic_3, author = "Finn", imagePage =
  "https://unsplash" +
      ".com/photos/6zr9ctxTmUo"
)
private val nycPic4 = Picture(
  image = R.drawable.ic_nyc_pic_4, author = "Kyler Boone",
  imagePage = "https://unsplash.com/photos/iBNKSkFftps"
)
private val nycPic5 = Picture(
  image = R.drawable.ic_nyc_pic_5, author = "Lerone Pieters",
  imagePage = "https://unsplash.com/photos/PTmrpv_2gUI"
)
val nycPics = listOf(nycPic1, nycPic2, nycPic3, nycPic4, nycPic5)

private val berlinPic1 = Picture(
  image = R.drawable.ic_berlin_pic_1, author = "Adam Vradenburg",
  imagePage = "https://unsplash.com/photos/g8DI2ZZFt8I"
)
private val berlinPic2 = Picture(
  image = R.drawable.ic_berlin_pic_2, author = "Nikita Pishchugin",
  imagePage = "https://unsplash.com/photos/aPeX2z3_PsI"
)
private val berlinPic3 = Picture(
  image = R.drawable.ic_berlin_pic_3, author = "Florian Wehde",
  imagePage = "https://unsplash.com/photos/rCOpnW9mxvc"
)
private val berlinPic4 = Picture(
  image = R.drawable.ic_berlin_pic_4, author = "Chris Reyem",
  imagePage = "https://unsplash.com/photos/98s5zpUjlSs"
)
private val berlinPic5 = Picture(
  image = R.drawable.ic_berlin_pic_5, author = "Julia Solonina",
  imagePage = "https://unsplash.com/photos/T_kZViNSe98"
)
val berlinPics = listOf(berlinPic1, berlinPic2, berlinPic3, berlinPic4, berlinPic5)

private val sfPic1 = Picture(
  image = R.drawable.ic_sf_pic_1, author = "Utsav Shah",
  imagePage = "https://unsplash.com/photos/R1Z2tCpl9Zk"
)
private val sfPic2 = Picture(
  image = R.drawable.ic_sf_pic_2, author = "Eric Ward",
  imagePage = "https://unsplash.com/photos/01wwOkz8ytk"
)
private val sfPic3 = Picture(
  image = R.drawable.ic_sf_pic_3, author = "Jason Leung",
  imagePage = "https://unsplash.com/photos/cYqEszzXU2g"
)
private val sfPic4 = Picture(
  image = R.drawable.ic_sf_pic_4, author = "Vlah Dumitru",
  imagePage = "https://unsplash.com/photos/zkngY5EvXF8"
)
private val sfPic5 = Picture(
  image = R.drawable.ic_sf_pic_5, author = "Fran", imagePage =
  "https://unsplash" +
      ".com/photos/WhLewrhNJh8"
)
val sfPics = listOf(sfPic1, sfPic2, sfPic3, sfPic4, sfPic5)

private val turinPic1 = Picture(
  image = R.drawable.ic_turin_pic_1, author = "Massimiliano " +
      "Morosinotto",
  imagePage = "https://unsplash.com/photos/PlRRMpAWZKU"
)
private val turinPic2 = Picture(
  image = R.drawable.ic_turin_pic_2, author = "David Salamanca",
  imagePage = "https://unsplash.com/photos/pOfgOeCrARo"
)
private val turinPic3 = Picture(
  image = R.drawable.ic_turin_pic_3, author = "Gabriel Rambaud",
  imagePage = "https://unsplash.com/photos/_lLx7WF2NVk"
)
private val turinPic4 = Picture(
  image = R.drawable.ic_turin_pic_4, author = "Mirko Mina",
  imagePage = "https://unsplash" +
      ".com/photos/lzIk6CesvWw"
)
private val turinPic5 = Picture(
  image = R.drawable.ic_turin_pic_5, author = "Giuseppe Patriarchi",
  imagePage = "https://unsplash.com/photos/xNkULZVw_xQ"
)
val turinPics = listOf(turinPic1, turinPic2, turinPic3, turinPic4, turinPic5)

private val londonPic1 = Picture(
  image = R.drawable.ic_london_pic_1, author = "Hugo Sousa",
  imagePage = "https://unsplash.com/photos/1Z7QDZqT2QQ"
)
private val londonPic2 = Picture(
  image = R.drawable.ic_london_pic_2, author = "Lachlan Gowen",
  imagePage = "https://unsplash.com/photos/RZ5TKFpdaWM"
)
private val londonPic3 = Picture(
  image = R.drawable.ic_london_pic_3, author = "Sabrina Mazzeo",
  imagePage = "https://unsplash.com/photos/g-krQzQo9mI"
)
private val londonPic4 = Picture(
  image = R.drawable.ic_london_pic_4, author = "Mariana Alves",
  imagePage = "https://unsplash.com/photos/pfnFC0ThFQ0"
)
private val londonPic5 = Picture(
  image = R.drawable.ic_london_pic_5, author = "Aaron Gilmore",
  imagePage = "https://unsplash.com/photos/aQLdDgROIZQ"
)
val londonPics = listOf(londonPic1, londonPic2, londonPic3, londonPic4, londonPic5)

private val parisPic1 = Picture(
  image = R.drawable.ic_paris_pic_1, author = "Arthur Humeau",
  imagePage = "https://unsplash.com/photos/3xwdarHxHqI"
)
private val parisPic2 = Picture(
  image = R.drawable.ic_paris_pic_2, author = "Anthony DELANOIX",
  imagePage = "https://unsplash.com/photos/Q0-fOL2nqZc"
)
private val parisPic3 = Picture(
  image = R.drawable.ic_paris_pic_3, author = "Adrien", imagePage =
  "https://unsplash" +
      ".com/photos/wAScP0OY-yM"
)
private val parisPic4 = Picture(
  image = R.drawable.ic_paris_pic_4, author = "Bastien Nvs",
  imagePage = "https://unsplash" +
      ".com/photos/SprV1eqNrqM"
)
private val parisPic5 = Picture(
  image = R.drawable.ic_paris_pic_5, author = "Sebastien Gabriel",
  imagePage = "https://unsplash.com/photos/gyUVNafCIG8"
)
val parisPics = listOf(parisPic1, parisPic2, parisPic3, parisPic4, parisPic5)
