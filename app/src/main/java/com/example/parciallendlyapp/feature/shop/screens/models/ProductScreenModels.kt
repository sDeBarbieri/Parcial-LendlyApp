package com.example.parciallendlyapp.feature.shop.screens.models

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.parciallendlyapp.R

// feature/shop/domain/model/ProductInfoData.kt
interface ProductInfoData {
    val title: String
    val row1: String
    val row2: String?
    val row3: String?
    val row4: String?
    val badgeText: String?
    val logoRes: Int?
    val showArrow: Boolean
    val isIcon: Boolean get() = false
}
data class MerchantModel(
    override val title: String,
    override val row1: String,
    override val row2: String? = null,
    override val row3: String? = null,
    override val row4: String? = null,
    override val badgeText: String? = null,
    override val logoRes: Int? = null,
    override val showArrow: Boolean = true,
) : ProductInfoData

data class FeatureModel(
    override val title: String,
    override val row1: String,
    override val row2: String? = null,
    override val row3: String? = null,
    override val row4: String? = null,
    override val badgeText: String? = null,
    override val logoRes: Int? = null,
    override val showArrow: Boolean = false,
    override val isIcon: Boolean = true
) : ProductInfoData

data class SpecsModel(
    override val title: String,
    override val row1: String,
    override val row2: String? = null,
    override val row3: String? = null,
    override val row4: String? = null,
    override val badgeText: String? = null,
    override val logoRes: Int? = null,
    override val showArrow: Boolean = true,
) : ProductInfoData

@Composable
fun getMerchantList(): List<MerchantModel> {
    return listOf(
        MerchantModel(
            title = stringResource(id = R.string.product_merchant_power_max),
            badgeText = stringResource(id = R.string.product_merchant_limited),
            row1 = stringResource(id = R.string.product_merchant_price_months),
            row2 = stringResource(id = R.string.product_merchant_total_price),
            row3 = stringResource(id = R.string.product_merchant_downpayment),
            logoRes = R.drawable.shop_logo_power_mac_center
        ),
        MerchantModel(
            title = stringResource(id = R.string.product_merchant_the_loop),
            badgeText = stringResource(id = R.string.product_merchant_limited),
            row1 = stringResource(id = R.string.product_merchant_price_months),
            row2 = stringResource(id = R.string.product_merchant_total_price),
            row3 = stringResource(id = R.string.product_merchant_downpayment),
            logoRes = R.drawable.shop_logo_the_loop
        ),
        MerchantModel(
            title = stringResource(id = R.string.product_merchant_imac),
            badgeText = stringResource(id = R.string.product_merchant_limited),
            row1 = stringResource(id = R.string.product_merchant_price_months),
            row2 = stringResource(id = R.string.product_merchant_total_price),
            row3 = stringResource(id = R.string.product_merchant_downpayment),
            logoRes = R.drawable.product_icon_apple
        )
    )
}

@Composable
fun getFeatureList():List<FeatureModel>{
    return listOf(
        FeatureModel(
            title = stringResource(id = R.string.product_apply_loan_title),
            row1 = stringResource(id = R.string.product_apply_loan_step_1),
            row2 = stringResource(id = R.string.product_apply_loan_step_2),
            logoRes = R.drawable.product_icon_hand,
            isIcon = true
        ),
        FeatureModel(
            title = stringResource(id = R.string.product_disclaimer_title),
            row1 = stringResource(id = R.string.product_disclaimer_desc),
            logoRes = R.drawable.product_icon_shield,
            isIcon = true
        )
    )
}

@Composable
fun getSpecsList():List<SpecsModel>{
    return listOf(
        SpecsModel(
            title = stringResource(id = R.string.product_specs_chip),
            row1 = stringResource(id = R.string.product_specs_chip_desc),
            row2 = stringResource(id = R.string.product_specs_cpu_desc),
            row3 = stringResource(id = R.string.product_specs_gpu_desc),
            row4 = stringResource(id = R.string.product_specs_neural_desc),
            showArrow = false
        ),
        SpecsModel(
            title = stringResource(id = R.string.product_specs_camera),
            row1 = stringResource(id = R.string.product_specs_camera_desc),
            row2 = stringResource(id = R.string.product_specs_aperture_desc),
            row3 = stringResource(id = R.string.product_specs_focus_desc),
            row4 = stringResource(id = R.string.product_specs_flash_desc),
            showArrow = false
        )
    )
}