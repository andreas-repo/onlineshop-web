<%@ include file="header.jspf"%>

    <form action="sell"
          enctype="multipart/form-data"
          method="post"><fieldset>
        <legend>Sell</legend>
        <table>
            <tbody>
            <tr>
                <th>
                    <label for="title">Title:</label>
                </th>
                <td>
                    <input
                            type="text"
                            name="title"
                            size="40"
                            maxlength="40"
                            title="Title for article"
                            placeholder="Input title"
                            pattern=".{6, 40}"
                            required="required">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="description">Description:</label>
                </th>
                <td>
                    <textarea
                            name="description"
                            cols="100"
                            rows="10"
                            maxlength="1000">
                    </textarea>
                </td>
            </tr>
            <tr>
                <th>
                    <label for="price">Price:</label>
                </th>
                <td>
                    <input
                            type="number"
                            name="price"
                            size="40"
                            maxlength="40"
                            title="Price for article"
                            placeholder="Input price"
                            pattern=".{1, 40}"
                            required="required">
                </td>
            </tr>
            <tr>
                <th>
                    <label for="photo">Photo:</label>
                </th>
                <td>
                    <input type="file" name="photo">
                </td>
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit">
                    <input type="reset">
                </td>
            </tr>
            </tbody>
        </table>
    </fieldset></form>

<%@ include file="footer.jspf"%>