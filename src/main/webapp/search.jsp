<%@ include file="header.jspf"%>

    <article>
        <section>
            <form action="search" method="post">
                <fieldset>
                    <legend>Search</legend>
                    <table>
                        <tbody>
                            <tr>
                                <th>
                                    <label for="search">Search:</label>
                                </th>
                                <td>
                                    <input
                                        type="text"
                                        name="search"
                                        size="40"
                                        maxlength="40"
                                        title="Searchtext"
                                        placeholder="Input search text">
                                </td>
                                <td>
                                    <input type="submit">
                                    <input type="reset">
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </fieldset>
            </form>
        </section>
    </article>

<%@ include file="footer.jspf"%>