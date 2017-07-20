<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>${person.firstName} ${person.lastName}</h1>
<p>License Number:  ${person.license.number}</p>
<p>State:   ${person.license.state}</p>
<p>Expiration Date: ${person.license.expirationDate}</p>