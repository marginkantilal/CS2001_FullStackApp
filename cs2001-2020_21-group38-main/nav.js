//to show navigation bar in different devices. 
//for validating the dropdown when clicked(show when clicked, to hide click again)
const $dropdown = $(".dropdown");
const $dropdownToggle = $(".dropdown-toggle");
const $dropdownMenu = $(".dropdown-menu");
const showClass = "show";

$(window).on("load resize", function() {
    if (this.matchMedia("(min-width: 768px)").matches) {
        $dropdown.hover(
            function() {
                const $this = $(this);
                $this.addClass(showClass);
                $this.find($dropdownToggle).attr("aria-expanded", "true");
                $this.find($dropdownMenu).addClass(showClass);
            },

        );
    } else {
        $dropdown.off("mouseenter mouseleave");//when mouse leave, the drop down disppears
    }
});

