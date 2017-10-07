/*!
 * Star Rating Portugese Brazilian Translations
 *
 * This file must be loaded after 'star-rating.js'. Patterns in braces '{}', or
 * any HTML markup tags in the messages must not be converted or translated.
 *
 * NOTE: this file must be saved in UTF-8 encoding.
 *
 * @see http://github.com/kartik-v/bootstrap-star-rating
 * @author Kartik Visweswaran <kartikv2@gmail.com>
 */
(function ($) {
    "use strict";
    $.fn.ratingLocales['pt-BR'] = {
        defaultCaption: '{rating} Estrelas',
        starCaptions: {
            0.5: 'Insatisfeito',
            1: 'Horrível',
            1.5: 'Péssimo',
            2: 'Muito Ruim',
            2.5: 'Ruim',
            3: 'Satisfeito',
            3.5: 'Bom',
            4: 'Muito Bom',
            4.5: 'Ótimo',
            5: 'Excelente'
        },
        clearButtonTitle: 'Limpar',
        clearCaption: 'Não Avaliado'
    };
})(window.jQuery);
