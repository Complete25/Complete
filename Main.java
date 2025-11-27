document.addEventListener('DOMContentLoaded', () => {
    // Logic to fix potential scroll alignment issues on refresh
    const links = document.querySelectorAll('.nav-links a');
    
    links.forEach(link => {
        link.addEventListener('click', (e) => {
            // While CSS scroll-snap handles the "snapping", 
            // this ensures the browser knows exactly where to jump immediately
            // without smooth scrolling (as requested).
            
            // Standard anchor behavior is usually fine, but strictly:
            const targetId = link.getAttribute('href').substring(1);
            const targetSection = document.getElementById(targetId);
            
            if(targetSection) {
                // We let default anchor click happen, but force focus
                // to ensure snap aligns perfectly.
                targetSection.scrollIntoView({ behavior: 'auto', block: 'center' });
            }
        });
    });
});