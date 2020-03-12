package com.candidate.servando.search

import com.candidate.servando.search.core.actions.FetchCategories
import com.candidate.servando.search.core.domain.Category
import com.candidate.servando.search.infrastructure.representation.CategoriesResponse
import com.candidate.servando.search.infrastructure.service.SearchService
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class FetchCategoriesTest {

    private lateinit var searchService: SearchService
    private lateinit var fetchCategories: FetchCategories

    @Before
    fun setup(){
        searchService = mock()
    }

    @Test
    fun `when fetch categories is invoked then a category list is obtained`(){
        givenCategoriesThroughSearchService()
        givenFetchCategories()
        whenFetchCategories()
        thenDomainCategoriesIsObtanained()
    }

    private fun givenCategoriesThroughSearchService() {
        whenever(searchService.fetchCategories()).thenReturn(Single.just(categoriesResponse))
    }

    private fun givenFetchCategories() {
        fetchCategories = FetchCategories(searchService)
    }

    private fun whenFetchCategories() {
        fetchCategories.invoke().test()
    }

    private fun thenDomainCategoriesIsObtanained() {
        fetchCategories.invoke().test().assertValue(categoriesDomain)
    }

    private companion object{

        val categoriesResponse =  listOf<CategoriesResponse>(
            CategoriesResponse("MLA5725", "Accesorios para Vehículos"),
            CategoriesResponse("MLA1512", "Agro"),
            CategoriesResponse("MLA1403", "Alimentos y Bebidas"),
            CategoriesResponse("MLA1071", "Animales y Mascotas"),
            CategoriesResponse("MLA1367", "Antigüedades y Colecciones"),
            CategoriesResponse("MLA1368", "Arte, Librería y Mercería"),
            CategoriesResponse("MLA1743", "Autos, Motos y Otros"),
            CategoriesResponse("MLA1384", "Bebés"),
            CategoriesResponse("MLA1246", "Belleza y Cuidado Personal"),
            CategoriesResponse("MLA1039", "Cámaras y Accesorios")
        )

        val categoriesDomain =  listOf<Category>(
            Category("MLA5725", "Accesorios para Vehículos"),
            Category("MLA1512", "Agro"),
            Category("MLA1403", "Alimentos y Bebidas"),
            Category("MLA1071", "Animales y Mascotas"),
            Category("MLA1367", "Antigüedades y Colecciones"),
            Category("MLA1368", "Arte, Librería y Mercería"),
            Category("MLA1743", "Autos, Motos y Otros"),
            Category("MLA1384", "Bebés"),
            Category("MLA1246", "Belleza y Cuidado Personal"),
            Category("MLA1039", "Cámaras y Accesorios")
        )
    }

}