package com.developer.anishakd4.ymedialabstest.models

data class MainModel(val variants: VariantsModel)

data class VariantsModel(val variant_groups: List<VariantGroupsModel>)

data class VariantGroupsModel(
    val group_id: String,
    val name: String,
    val variations: List<VariationsModel>
)

data class VariationsModel(
    val name: String,
    val price: Int,
    val default: Int,
    val id: String,
    val inStock: Int
)