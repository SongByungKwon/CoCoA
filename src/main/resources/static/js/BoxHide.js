function hello() {
    if(box1.style.display !== 'none') {
        box0.style.display = 'none';
        box1.style.display = 'none';
        box2.style.display = 'none';
        box3.style.display = 'none';
        box4.style.display = 'none';
        subbox.style.display='none';

    }
    // btn` 보이기 (display: block)
    else {
        box0.style.display = 'block';
        box1.style.display = 'block';
        box2.style.display = 'block';
        box3.style.display = 'block';
        box4.style.display = 'block';
    }
}